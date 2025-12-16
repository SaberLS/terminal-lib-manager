package pl.wszib.java.advanced.services.permission;

import java.util.Set;

import pl.wszib.java.advanced.model.User;
import pl.wszib.java.advanced.model.operation.Operation;

public interface IPermissionService {
  public Set<Operation> getPermissions(User user);
}
