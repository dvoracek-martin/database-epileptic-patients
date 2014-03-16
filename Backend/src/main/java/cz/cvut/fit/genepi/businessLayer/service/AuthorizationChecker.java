package cz.cvut.fit.genepi.businessLayer.service;

import javax.servlet.http.HttpServletRequest;

public interface AuthorizationChecker {
    public boolean checkAuthoritaion(HttpServletRequest request);

    public boolean onlyResearcher();

    public boolean isAdmin();

    public boolean isUserFromUrl(int userId);

    public boolean isSuperDoctor();
}
