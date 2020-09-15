public class Decrypter {
    public static String decrypt(String encoded_value)
    {
        String unswapped = unswap(encoded_value);
        String decoded = "";
        for (int i = 0; i < unswapped.length(); i++)
        {
            decoded += unencrypt_digit(unswapped.charAt(i));
        }
        return decoded;
    }

    public static String unencrypt_digit(char digit)
    {
        String digit_as_string = Character.toString(digit);
        int plaintext_digit = Integer.parseInt(digit_as_string);

        plaintext_digit -= 7;
        if (plaintext_digit < 0)
        {
            plaintext_digit += 10;
        }

        return Integer.toString(plaintext_digit);
    }
    public static String unswap(String swapped)
    {
        String unswapped = "";
        unswapped += swapped.charAt(2);
        unswapped += swapped.charAt(3);
        unswapped += swapped.charAt(0);
        unswapped += swapped.charAt(1);
        return unswapped;
    }
}
