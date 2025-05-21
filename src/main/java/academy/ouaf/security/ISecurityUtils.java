package academy.ouaf.security;

public interface ISecurityUtils {

    /**
     * Get the role of the user from UserDetails.
     */
    String getRole(AppUserDetails userDetails);

    /**
     * Generate a JWT token for the user.
     */
    String generateToken(AppUserDetails userDetails);

    /**
     * Extract the subject (usually email or user ID) from the JWT token.
     */
    String getSubjectFromJwt(String jwt);
}