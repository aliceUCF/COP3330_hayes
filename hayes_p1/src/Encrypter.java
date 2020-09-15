public class Encrypter{
    public static String encrypt(String plaintext)
    {
        String encrypted_string = "";
        for (int i = 0; i < plaintext.length(); i++)
        {
            encrypted_string += encrypt_digit((plaintext.charAt(i)));
            System.out.println("encryption is " + encrypted_string);
        }
        encrypted_string = swap_digits(encrypted_string);
        return encrypted_string;
    }

    public static String encrypt_digit(char digit)
    {
        String digit_as_string = Character.toString(digit);
        int encrypted_digit = Integer.parseInt(digit_as_string);

        encrypted_digit = encrypted_digit + 7;
        encrypted_digit %= 10;

        return Integer.toString(encrypted_digit);
    }

    public static String swap_digits(String plaintext)
    {
        String swapped_string = "";
        swapped_string += plaintext.charAt(2);
        swapped_string += plaintext.charAt(3);
        swapped_string += plaintext.charAt(0);
        swapped_string += plaintext.charAt(1);
        return swapped_string;
    }
}

