package com.invokeforeignfunction;

import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.SymbolLookup;

import java.io.IOException;
import java.lang.invoke.MethodType;

import static jdk.incubator.foreign.ResourceScope.newImplicitScope;

public class ForeignFunctionInvoker
{
    private static final SymbolLookup libraryLookup;

    static
    {
        var resource = ForeignFunctionInvoker.class.getResource("compile_c.sh");
        try
        {
            new ProcessBuilder("sh", resource.getPath())
                    .start();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        var path = ForeignFunctionInvoker.class.getResource("/print_name.so").getPath();
        System.load(path);
        libraryLookup = SymbolLookup.loaderLookup();
    }

    public static void main(String... args)
    {
        System.out.println("Invoke C function");
    }

    private static String getPrintNameFormat(String name)
    {

        var printMethod = libraryLookup.lookup("printName");

        if (printMethod.isPresent())
        {
            var methodReference = CLinker.getInstance()
                    .downcallHandle(
                            printMethod.get(),
                            MethodType.methodType(MemoryAddress.class, MemoryAddress.class),
                            FunctionDescriptor.of(CLinker.C_POINTER, CLinker.C_POINTER));

            try
            {
                var nativeString = CLinker.toCString(name, newImplicitScope());
                var invokeReturn = methodReference.invoke(nativeString.address());
                var memoryAddress = (MemoryAddress) invokeReturn;
                return CLinker.toJavaString(memoryAddress);
            }
            catch (Throwable throwable)
            {
                throw new RuntimeException(throwable);
            }
        }
        throw new RuntimeException("printName function not found.");
    }

}
