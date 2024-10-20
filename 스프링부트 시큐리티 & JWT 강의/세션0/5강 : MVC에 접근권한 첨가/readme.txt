- @Secured(”ROLE_ADMIN”)
    - ROLE_ADMIN 권한을 가질 시, 해당 함수 사용 가능
- @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
    - ROLE_MANAGER 또는 ROLE ADMIN 권한을 가질 시, 해당 함수 사용 가능

체인 필터
- @Secure, @PreAuthorize 사용 권한을 줘야함
- ⇒ @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
