
INSERT INTO db_usermanagement.`function` (func_id,func_name,func_code,url,func_icon,parent_id,seq_no,system_code,func_type,status,is_ca_system,component,create_time,create_by,update_time,update_by) VALUES

,(27028,'三级医院绩效考核系统','PAHM.home','','',0,NULL,'1','0','1',NULL,NULL,'2021-01-11 14:54:23.0',NULL,NULL,NULL)
,(27029,'经营类','SSO.Box.Run',NULL,NULL,27027,0,'70','2','1',NULL,NULL,NULL,NULL,NULL,NULL)
,(27030,'罗湖医院考核系统','SSO.Box.Run.jixiaokaohe','http://192.168.5.20:5000/#/','8.png',27029,NULL,'70','3','1',NULL,NULL,'2020-12-21 14:45:56.0',NULL,NULL,NULL)
,(27031,'指标填报','PAHM.norm-input','','icon-icon-edit',27028,3,'1','1','1',NULL,NULL,'2021-01-11 14:56:50.0',NULL,NULL,NULL)
;
INSERT INTO db_usermanagement.`function` (func_id,func_name,func_code,url,func_icon,parent_id,seq_no,system_code,func_type,status,is_ca_system,component,create_time,create_by,update_time,update_by) VALUES
(27032,'指标管理','PAHM.norm-management','','icon-icon-setting',27028,2,'1','1','1',NULL,NULL,'2021-01-11 14:58:56.0',NULL,NULL,NULL)
,(27033,'绩效考核','PAHM.performance','','icon-icon-assessment',27028,1,'1','1','1',NULL,NULL,'2021-01-11 15:03:37.0',NULL,NULL,NULL)
,(27034,'首页','PAHM.performance-index','/performance-index','',27033,1,'1','2','1',NULL,NULL,'2021-01-11 15:04:53.0',NULL,NULL,NULL)
,(27035,'医疗质量','PAHM.performance-quality','/performance-quality','',27033,2,'1','2','1',NULL,NULL,'2021-01-11 15:05:50.0',NULL,NULL,NULL)
,(27036,'运营效率','PAHM.performance-operation','/performance-operation','',27033,3,'1','2','1',NULL,NULL,'2021-01-11 15:07:21.0',NULL,NULL,NULL)
,(27037,'持续发展','PAHM.performance-development','/performance-development','',27033,4,'1','2','1',NULL,NULL,'2021-01-11 15:09:10.0',NULL,NULL,NULL)
,(27038,'满意度','PAHM.performance-satisfaction','/performance-satisfaction','',27033,5,'1','2','1',NULL,NULL,'2021-01-11 15:10:58.0',NULL,NULL,NULL)
,(27039,'指标科室权限管理','PAHM.norm-permission-list','/norm-permission-list','',27032,1,'1','2','1',NULL,NULL,'2021-01-11 15:12:29.0',NULL,NULL,NULL)
,(27041,'指标设置','PAHM.norm-setting-list','/norm-setting-list','',27032,2,'1','2','1',NULL,NULL,'2021-01-11 15:21:45.0',NULL,NULL,NULL)
,(27043,'指标填报管理','PAHM.norm-input-list','/norm-input-list','',27031,NULL,'1','2','1',NULL,NULL,'2021-01-11 15:27:44.0',NULL,NULL,NULL)
;
INSERT INTO db_usermanagement.`function` (func_id,func_name,func_code,url,func_icon,parent_id,seq_no,system_code,func_type,status,is_ca_system,component,create_time,create_by,update_time,update_by) VALUES
(27045,'指标科室权限明细','PAHM.norm-permission-edit','/norm-permission-edit','',27039,NULL,'1','2','1',NULL,NULL,'2021-01-11 15:46:33.0',NULL,NULL,NULL)
,(27046,'指标填报明细','PAHM.norm-input-edit','/norm-input-edit','',27043,NULL,'1','2','1',NULL,NULL,'2021-01-11 15:47:46.0',NULL,NULL,NULL)
,(27047,'指标登记','PAHM.norm-setting-record','/norm-setting-record','',27032,3,'1','2','1',NULL,NULL,'2021-01-11 16:08:15.0',NULL,NULL,NULL)
,(27049,'指标详情','PAHM.norm-setting-edit','/norm-setting-edit','',27041,NULL,'1','2','1',NULL,NULL,'2021-01-11 16:15:21.0',NULL,NULL,NULL)
,(27050,'指标版本设置','PAHM.norm-setting-version','/norm-setting-version','',27032,4,'1','2','1',NULL,NULL,'2021-01-18 13:43:01.0',NULL,NULL,NULL)
,(27051,'院级','PAHM.performance-operation-level1','/performance-operation-level1','',27036,NULL,'1','1','1',NULL,NULL,'2021-01-21 09:59:06.0',NULL,NULL,NULL)
,(27052,'业务级','PAHM.performance-operation-level2','/performance-operation-level2','',27051,NULL,'1','1','1',NULL,NULL,'2021-01-21 11:23:51.0',NULL,NULL,NULL)
,(27053,'科室级','PAHM.performance-operation-level3','/performance-operation-level3','',27052,NULL,'1','1','1',NULL,NULL,'2021-01-21 11:24:43.0',NULL,NULL,NULL)
,(27054,'二级科室','PAHM.performance-operation-level4','/performance-operation-level4','',27053,NULL,'1','1','1',NULL,NULL,'2021-01-21 11:26:16.0',NULL,NULL,NULL)
,(27055,'医师级','PAHM.performance-operation-level5','/performance-operation-level5','',27054,NULL,'1','1','1',NULL,NULL,'2021-01-21 11:26:59.0',NULL,NULL,NULL)
;




update db_usermanagement.`function` set  url = 'http://172.16.33.175:8081/#/' where func_id = 27030;

--update db_usermanagement.`function` set  func_code = 'PAHM.home' where func_id = 27028;

INSERT INTO db_usermanagement.dict_data
(dict_id, dict_code, dict_name, item_code, item_name, seq_no, status )
VALUES(11111, '1111', '医疗机构', '1111', '深圳市罗湖人民医院', 8, '1');