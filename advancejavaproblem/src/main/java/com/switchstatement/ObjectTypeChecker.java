package com.switchstatement;

public class ObjectTypeChecker
{

    public static void main(String... args)
    {
        System.out.println(checkObjectType("Hello"));
        System.out.println(checkObjectType(Integer.valueOf(12)));
        System.out.println(checkObjectType(13.5d));
        System.out.println(checkObjectType(14.5f));
    }

    // no need of instanceOf operator
    private static String checkObjectType(Object obj)
    {
        switch (obj)
        {
            case String string ->
            {
                return String.format("MyString %s", string);
            }
            case Integer integer ->
            {
                return String.format("Integer Value %d", integer);
            }
            case Double d ->
            {
                return String.format("Double value %f", d);
            }
            default ->
            {
                return String.format("Unknown Type");
            }
        }
    }

    // Need type cast
    private void checkTypeLegacyWay(Object object)
    {
        if (object instanceof String)
        {
            String s = (String) object;
            String.format("String %s", s);
        }
        else if (object instanceof Integer)
        {
            Integer i = (Integer) object;
            String.format("int %d", i);
        }
        else if (object instanceof Double)
        {
            Double d = (Double) object;
            String.format("double %f", d);
        }
    }

}
