package com.catalis.idp.adapter;

import com.catalis.idp.dtos.*;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Identity Provider (IdP) adapter interface that standardizes common authentication and
 * user‑management operations across different IdPs such as Keycloak, AWS Cognito, Okta, etc.
 *
 * Implementations should translate these generic operations into the specific API calls of the
 * target provider while keeping a consistent, reactive API based on Reactor's Mono.
 */
public interface IdpAdapter {

    /**
     * Authenticate a user and obtain tokens.
     *
     * Typical mapping is an OAuth2/OIDC token endpoint using Resource Owner Password Credentials,
     * or any custom username/password flow supported by the provider.
     *
     * @param request credentials and client details for the login attempt
     * @return a reactive publisher yielding a ResponseEntity with a TokenResponse on success
     */
    Mono<ResponseEntity<TokenResponse>> login(LoginRequest request);

    /**
     * Refresh the access token using a refresh token.
     *
     * @param request refresh token and (optionally) client info
     * @return a reactive publisher with a ResponseEntity containing a new TokenResponse
     */
    Mono<ResponseEntity<TokenResponse>> refresh(RefreshRequest request);

    /**
     * Invalidate an access token or perform a provider-specific logout.
     *
     * Implementations may call the IdP's logout or token revocation endpoint.
     *
     * @param accessToken the access token to invalidate
     */
    void logout(String accessToken);

    /**
     * Introspect an access token to verify its activity and claims (RFC 7662).
     *
     * @param accessToken the token to introspect
     * @return a reactive publisher with a ResponseEntity containing introspection details
     */
    Mono<ResponseEntity<IntrospectionResponse>> introspect(String accessToken);

    /**
     * Retrieve OpenID Connect user info associated with the provided access token.
     *
     * @param accessToken a valid access token
     * @return a reactive publisher with a ResponseEntity containing user info claims
     */
    Mono<ResponseEntity<UserInfoResponse>> getUserInfo(String accessToken);

    /**
     * Create a new user at the identity provider.
     *
     * @param request details required to create the user (username, email, etc.)
     * @return a reactive publisher with a ResponseEntity containing the created user's summary
     */
    Mono<ResponseEntity<CreateUserResponse>> createUser(CreateUserRequest request);

    /**
     * Change a user's password.
     *
     * Implementations should enforce provider-specific requirements (e.g., old password check).
     *
     * @param request contains user identifier and new/old passwords
     */
    void changePassword(ChangePasswordRequest request);

    /**
     * Trigger a password reset for a given username (e.g., send reset email/SMS).
     *
     * @param username the username (or login identifier) for which to initiate reset
     */
    void resetPassword(String username);

    /**
     * Initiate a Multi‑Factor Authentication (MFA) challenge for a user.
     *
     * @param username the username to challenge
     * @return a reactive publisher with challenge details (delivery method, expiry, etc.)
     */
    Mono<ResponseEntity<MfaChallengeResponse>> mfaChallenge(String username);

    /**
     * Verify a previously initiated MFA challenge with the supplied code.
     *
     * @param request verification payload including challenge id and code
     */
    void mfaVerify(MfaVerifyRequest request);

    /**
     * Revoke an issued refresh token.
     *
     * @param refreshToken the refresh token to revoke
     */
    void revokeRefreshToken(String refreshToken);

    /**
     * List active sessions for a given user.
     *
     * @param userId the user identifier
     * @return a reactive publisher with a list of session information
     */
    Mono<ResponseEntity<List<SessionInfo>>> listSessions(String userId);

    /**
     * Revoke a specific session by its identifier.
     *
     * @param sessionId the session identifier to revoke
     */
    void revokeSession(String sessionId);

    /**
     * Retrieve the roles assigned to a user.
     *
     * @param userId the user identifier
     * @return a reactive publisher with the list of role names
     */
    Mono<ResponseEntity<List<String>>> getRoles(String userId);
}
