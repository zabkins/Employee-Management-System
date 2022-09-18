package pl.zarczynski.ems.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.zarczynski.ems.Repository.EmployeeRepository;
import pl.zarczynski.ems.domain.Employee;

@Component
public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder encoder;

    public MyAuthenticationProvider(EmployeeRepository employeeRepository, PasswordEncoder encoder) {
        this.employeeRepository = employeeRepository;
        this.encoder = encoder;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        //
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        String authenticationUsername = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        Employee employee = employeeRepository.findByUsername(authenticationUsername).orElseThrow(() -> new UsernameNotFoundException("User with given username not found!"));
        if(encoder.matches(password,employee.getPassword())){
            return MyUserDetails.build(employee);
        } else {
            throw new BadCredentialsException("Bad credentials");
        }
    }
}
