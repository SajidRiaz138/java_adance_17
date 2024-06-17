package com.textblocks;

public class TextBlockMultiLineStringHandler
{
    public static void main(String... args)
    {
        //System.out.println(getMultiLineString());
        System.out.println(getXmlFormattedString());
    }

    private static String getXmlFormattedString()
    {
        String xmlString = """
                <company>
                    <name>
                    %s
                    </name>
                    <address>
                    %s
                    </address>
                </company>
                """.formatted("abc", "371 20G");
        return xmlString;
    }

    private static String getMultiLineString()
    {
        String jsonString = """
                {
                  "squadName": "Super hero squad",
                  "homeTown": "Metro City",
                  "formed": 2016,
                  "secretBase": "Super tower",
                  "active": true,
                  "members": [
                    {
                      "name": "Molecule Man",
                      "age": 29,
                      "secretIdentity": "Dan Jukes",
                      "powers": ["Radiation resistance", "Turning tiny", "Radiation blast"]
                    },
                    {
                      "name": "Madame Uppercut",
                      "age": 39,
                      "secretIdentity": "Jane Wilson",
                      "powers": [
                        "Million tonne punch",
                        "Damage resistance",
                        "Superhuman reflexes"
                      ]
                    },
                    {
                      "name": "Eternal Flame",
                      "age": 1000000,
                      "secretIdentity": "Unknown",
                      "powers": [
                        "Immortality",
                        "Heat Immunity",
                        "Inferno",
                        "Teleportation",
                        "Interdimensional travel"
                      ]
                    }
                  ]
                }

                """;
        return jsonString;
    }
}
