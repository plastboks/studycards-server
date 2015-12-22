package net.plastboks.studycards.exception;

/**
 * Created by alex on 12/20/15.
 */
public class StudentNotFoundException extends RuntimeException
{
    public StudentNotFoundException(String email)
    {
        super("could not fined user: " + email);
    }
}
