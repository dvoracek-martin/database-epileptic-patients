package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.VO.form.UserVO;

import java.util.HashMap;
import java.util.Locale;

/**
 * The Interface MailService extends GenericService
 */
public interface MailService {
    public void sendMail(String recipient, HashMap<String, Object> map,
                         Locale locale) throws Exception;

    public void notifyChangedPassword(UserVO user,String password,Locale locale);
}
