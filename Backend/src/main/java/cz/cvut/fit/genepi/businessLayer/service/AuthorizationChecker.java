package cz.cvut.fit.genepi.businessLayer.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Martin on 27.2.14.
 */
public interface AuthorizationChecker {
    public boolean checkAuthoritaion(HttpServletRequest request);

    public boolean  onlyResearcher();

    public boolean isAdmin();

    public boolean isUserFromUrl(int userId);
}