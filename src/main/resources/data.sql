CREATE TABLE IF NOT EXISTS alerts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    alertID VARCHAR(255) NOT NULL,
    createdtime VARCHAR(255) NOT NULL,
    env VARCHAR(255) NOT NULL,
    count INT NOT NULL,
    active VARCHAR(255) NOT NULL,
    severity VARCHAR(255) NOT NULL
);

-- Add a unique constraint to the alertID column
ALTER TABLE alerts
ADD CONSTRAINT UK_alertID UNIQUE (alertID);

-- Insert data into Alerts1
INSERT INTO alerts (alertID, createdtime, env, count, active, severity)
VALUES
  ('ERROR01' ,'2023-09-14T08:00:00', 'POD1', 10, 'Y', 'CRITICAL'),
  ('ERROR02', '2023-09-14T08:00:00','POD2', 15, 'N', 'MEDIUM'),
  ('ERROR03', '2023-09-14T08:00:00', 'POD3', 20, 'Y', 'LOW'),
  
  ('ERROR04',  '2023-09-14T08:15:00', 'POD1', 5, 'Y', 'MEDIUM'),
  ('ERROR05', '2023-09-14T08:15:00', 'POD2', 8, 'N', 'CRITICAL'),
  ('ERROR06', '2023-09-14T08:15:00', 'POD3', 12, 'Y', 'LOW');





 -- Create table Alerts1Resolution
CREATE TABLE alerts_resolution (
    id INT AUTO_INCREMENT PRIMARY KEY,
    alertID VARCHAR(255) NOT NULL,
    error_Desc VARCHAR(2000) NOT NULL,
    resolution VARCHAR(1000) NOT NULL,
    team VARCHAR(255) NOT NULL,
    contact VARCHAR(255) NOT NULL
);


  


-- Insert data into Alerts1Resolution
-- Resolution for ERROR01
INSERT INTO alerts_resolution(alertID,error_Desc, resolution, team, contact)
VALUES
  ('ERROR01', 'Use this link to generate correct AES encrypted password https://engci-private-sjc.cisco.com/jenkins/mv-jenkins003/view/SELF_SERVICES/job/SELF_SERVICES/job/CC_AES_ENCRYPTION/ Update the AES encrypted string by DB Patch and try to login in to CC application. ','Resolution for ERROR01 - Critical Issue: restart the server or pod', 'DS and PS Team', 'ds_support@cisco.com or ps_support@cisco.com'),
  ('ERROR02', ' With help of SRE/PS team check queue on mailq4. SRE/PS can delete email queue on mailq4, and reduced disk space to help resolve this issue. (NOTE: Space clearing will take 4 to 5 hours) After the disk space is cleared, PS will restart the server','Resolution for ERROR01 - Medium Issue', 'DS Team', 'ds_support@cisco.com'),
  ('ERROR03', 'Issue : AT&T Mobility - Unable to create new usernames 2020-09-08 11:32:53,994 [pd1sjc-pgw-27 http-bio-8080-exec-925] ERROR com.jasperwireless.rest.BaseController [] [] [env=dc1;key=--1599589973483;reqTime=1599589973483;c1=/v1/auth/newPassword/newFlow;] - Error processing: http://simcontrolcenter.wireless.att.com/provision/api/v1/auth/newPassword/newFlow;jsessionid=656BE168EEE3E5006ED683FBC0417ACC java.lang.IllegalArgumentException: Unknown return value type [java.lang.Boolean] at org.springframework.util.Assert.notNull(Assert.java:112) ~[spring-core-3.2.18.RELEASE.jar:3.2.18.RELEASE] at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:68) ~[spring-web-3.2.18.RELEASE.jar:3.2.18.RELEASE] at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:122) ~[spring-webmvc-3.2.18.RELEASE.jar:3.2.18.RELEASE] at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:743) ~[spring-webmvc-3.2.18.RELEASE.jar:3.2.18.RELEASE]','Resolution for ERROR01 - Low Issue', 'Security Team', 'security_support@cisco.com'),
  ('ERROR04', 'NETWORK_REGISTER_IN_ZONE Automation Rules is failing on POD ERROR com.jasperwireless.batch.messaging.push.HttpSenderExt [] [env=pod7-sjc;key=;c1=consumer.pushApiDeliveryQ__acct100147913;] - NETWORK_REGISTER_IN_ZONE-89550522060003617819-1550085967000: Error returned from url=https://api-autogw-test-i.jasper.com/staging/gmsaGateway/api/v1/devices/networkAttach;status=HTTP/1.1 406 ;time=48;body=Fail to parse the data into registrationInZone object.','Resolution for ERROR01 - Low Issue', 'Support and Platform Team', 'supportteam@cisco.com or platform_support@cisco.com');

