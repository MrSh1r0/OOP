package oop.version;

public class VersionNumber
{
    public static int compare(String v1, String v2)
    {
        int result = 0;
        if (v1 == null || v2 == null)
        {
            throw new NumberFormatException("ungueltig");
        }
        String[] parts1 = v1.split("\\.");
        String[] parts2 = v2.split("\\.");
        if (parts1.length == 0 || parts2.length == 0)
        {
            throw new NumberFormatException("ungueltig");
        }
        int length = Math.max(parts1.length, parts2.length);
        for (int i = 0; i < length; i++)
        {
            int part1 = (i < parts1.length ? Integer.parseInt(parts1[i]) : 0);
            int part2 = (i < parts2.length ? Integer.parseInt(parts2[i]) : 0);
            if (part1 < 0 || part2 < 0)
            {
                throw new NumberFormatException("ungueltig");
            }
            if (part1 < part2)
            {
                result = -1;
                break;
            }
            if (part1 > part2)
            {
                result = 1;
                break;
            }
        }
        return result;

    }

    public static void main(String[] args)
    {
        System.out.println(compare("1.2.3.19.20.21.22.23.24", "1.3"));
        // System.out.println(compare("-1.2.3", "1.2.3"));
        System.out.println(compare(".", "1.2.3"));
    }
}
