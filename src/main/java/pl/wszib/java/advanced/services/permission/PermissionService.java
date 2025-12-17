package pl.wszib.java.advanced.services.permission;

import java.util.Set;

import org.springframework.stereotype.Service;

import pl.wszib.java.advanced.model.User;
import pl.wszib.java.advanced.model.operation.Operation;
import pl.wszib.java.advanced.security.RolePermissions;

@Service
public class PermissionService implements IPermissionService {
  @Override
  public Set<Operation> getPermissions(User user) {
    return RolePermissions.getPermissions(user.getRole());
  }
}
