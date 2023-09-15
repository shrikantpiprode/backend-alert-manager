package com.internal.alertmanager.service;

import com.internal.alertmanager.models.jira.Assignee;
import com.internal.alertmanager.models.jira.AvatarUrls;
import com.internal.alertmanager.models.jira.Fields;
import com.internal.alertmanager.models.jira.Issuetype;
import com.internal.alertmanager.models.jira.Jira;
import com.internal.alertmanager.models.jira.Project;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private final String JIRA_API_URI = "https://criticalissues.atlassian.net/rest/api/2/issue/";
    public String createJiraNotification(String summaryStr) throws URISyntaxException {
        //Integrate with JIRA APIs
        String encypPassword= "hO0jQo7xtdUsCPYili/pqbYsQFgvIGzfwW5HulSGDMOyLNDbBBB/aiZwXds/tFiH/8mNqSQVDWU6AIXJUIyRpDq0L+uTxJyvFgxQq4gRcHmJRa4S8AMYOaUC/0VTRFZbbx9Rr0EPBOhWesW3WRKl9DJTkIcQf7dBo74yMLTSRP4op7EdQQGmngYzXsa3uRB+9vMzZLASP7AZbcUDhFWcAueBc/ALH9vE2SulQNyqsTxQNafQwDm2Eg5EhlXYYCou8jlbI8dAKSj0lqpSd+st8A==";
        String secretKey = "shrikantshrikantshrikant";
        HttpHeaders headers = new HttpHeaders();
       String orginalpassword=null;
    try {
        orginalpassword = decrypt(encypPassword,secretKey);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBasicAuth("shiveshyadav@gmail.com",
                orginalpassword);

        HttpEntity<Jira> entity = new HttpEntity<Jira>(prepareJira(summaryStr),headers);

        URI uri = new URI(JIRA_API_URI);
        ResponseEntity responseEntity = restTemplate.postForEntity(uri,entity,String.class);
        logger.info("responseStr --- "+responseEntity);
        return "SUCCESS";
    }

     public String decrypt(String encryptedText, String secretKey) throws Exception {
        // Create a SecretKey from the provided key bytes
        byte[] keyBytes = secretKey.getBytes("UTF-8");
        SecretKey key = new SecretKeySpec(keyBytes, "AES");

        // Initialize the cipher for decryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        // Decode the Base64 encoded encrypted text
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);

        // Decrypt the text
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Convert the decrypted bytes back to a string
        return new String(decryptedBytes, "UTF-8");
    }
    private Jira prepareJira(String summaryStr){
        Jira  jira = new Jira();
        jira.setExpand("renderedFields,names,schema,operations,editmeta,changelog,versionedRepresentations,customfield_10010.requestTypePractice");
        jira.setId(String.valueOf(Math.random()));
        jira.setSelf("https://criticalissues.atlassian.net/rest/api/2/issuetype/10001");
        jira.setFields(getFieldsObj(summaryStr));
        return jira;
    }

    private Fields getFieldsObj(String summaryStr) {
        Fields fields = new Fields();
        fields.setSummary(summaryStr);
        fields.setIssuetype(getIssueTypeObj());
        fields.setAssignee(getAssigneeObj());
        fields.setProject(getProjectObj());
        return fields;
    }

    private Project getProjectObj() {
        Project project = new Project();
        project.setId("10000");
        project.setSelf("https://criticalissues.atlassian.net/rest/api/2/project/10000");
        project.setName("CriticalIssueResolver");
        project.setAvatarUrls(getAvatarUrlsObj_forProject());
        project.setProjectTypeKey("software");
        project.setKey("CRIT");
        project.setSimplified(true);
        return project;
    }
    private AvatarUrls getAvatarUrlsObj_forProject() {
        AvatarUrls avatarUrls = new AvatarUrls();
        avatarUrls.set_16x16("https://criticalissues.atlassian.net/rest/api/2/universal_avatar/view/type/project/avatar/10411?size=xsmall");
        avatarUrls.set_24x24("https://criticalissues.atlassian.net/rest/api/2/universal_avatar/view/type/project/avatar/10411?size=small");
        avatarUrls.set_32x32("https://criticalissues.atlassian.net/rest/api/2/universal_avatar/view/type/project/avatar/10411?size=medium");
        avatarUrls.set_48x48("https://criticalissues.atlassian.net/rest/api/2/universal_avatar/view/type/project/avatar/10411");
        return avatarUrls;
    }

    private Assignee getAssigneeObj() {
        Assignee assignee = new Assignee();
        assignee.setActive(true);
        assignee.setSelf("https://criticalissues.atlassian.net/rest/api/2/user?accountId=557058%3A966d5112-5d4b-4974-80cf-b66b87753c7a");
        assignee.setAccountId("557058:966d5112-5d4b-4974-80cf-b66b87753c7a");
        assignee.setAccountType("atlassian");
        assignee.setDisplayName("Shiv Yadav");
        assignee.setEmailAddress("shiveshyadav@gmail.com");
        assignee.setTimeZone("Asia/Calcutta");
        assignee.setAvatarUrls(getAvatarUrlsObj());
        return assignee;
    }

    private AvatarUrls getAvatarUrlsObj() {
        AvatarUrls avatarUrls = new AvatarUrls();
        avatarUrls.set_16x16("https://secure.gravatar.com/avatar/210c9968c5275a9df682f73e17dd83f2?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FSY-6.png");
        avatarUrls.set_24x24("https://secure.gravatar.com/avatar/210c9968c5275a9df682f73e17dd83f2?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FSY-6.png");
        avatarUrls.set_32x32("https://secure.gravatar.com/avatar/210c9968c5275a9df682f73e17dd83f2?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FSY-6.png");
        avatarUrls.set_48x48("https://secure.gravatar.com/avatar/210c9968c5275a9df682f73e17dd83f2?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FSY-6.png");
        return avatarUrls;
    }

    private Issuetype getIssueTypeObj() {
        Issuetype issuetype = new Issuetype();
        issuetype.setId("10001");
        issuetype.setSelf("https://criticalissues.atlassian.net/rest/api/2/issuetype/10001");
        issuetype.setAvatarId(10318);
        issuetype.setDescription("Test Error description");
        issuetype.setName("TASK");
        issuetype.setSubtask(false);
        issuetype.setIconUrl("https://criticalissues.atlassian.net/rest/api/2/universal_avatar/view/type/issuetype/avatar/10318?size=medium");
        issuetype.setHierarchyLevel(0);
        return issuetype;
    }
}
