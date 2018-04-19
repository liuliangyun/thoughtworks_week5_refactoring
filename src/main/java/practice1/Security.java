package practice1;

import com.google.common.collect.ImmutableList;

public class Security {

    private SecurityChecker securityChecker;

    public Security(SecurityChecker checker) {
        this.securityChecker = checker;
    }

    public boolean hasAccess(User user, Permission permission, ImmutableList<Permission> permissions) {
        // Consolidate Conditional Expression 合并条件表达式
        if (isLegalInput(user, permission, permissions) && isAccess(user, permission, permissions)) {
            return true; // Replaced Nested Conditional with Guard Clauses 以卫语句取代嵌套条件表达式
        }
        return false;
    }

    private boolean isLegalInput(User user, Permission permission, ImmutableList<Permission> permissions) {
        return ((user != null) && (permission != null) && (permissions.size() > 0));
    }

    private boolean isAccess(User user, Permission permission, ImmutableList<Permission> permissions) {
        return (securityChecker.isAdmin() || securityChecker.checkPermission(user, permission) || permissions.contains(permission));
    }
}
