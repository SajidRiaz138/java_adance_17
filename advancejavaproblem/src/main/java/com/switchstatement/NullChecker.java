package com.switchstatement;

public class NullChecker
{

    public static void main(String... args)
    {
        System.out.println(parseNullStringInSwitchBeforeJava17(null));
        System.out.println(parseNullStringInSwitchBeforeJava17("ABC"));
        System.out.println(parseNullStringInSwitchWithJava17(null));
    }

    private static String parseNullStringInSwitchWithJava17(String string)
    {
        switch (string)
        {
            case null ->
            {
                return "String is Null";
            }
            case "Bird" ->
            {
                return "Bird is flying";
            }
            default ->
            {
                return "default";
            }
        }
    }

    private static String parseNullStringInSwitchBeforeJava17(String string)
    {
        if (string == null)
        {
            return "String is Null";
        }

        switch (string)
        {
            case "Bird" ->
            {
                return "Bird is flying";
            }
            default ->
            {
                return "default";
            }
        }
    }
}
