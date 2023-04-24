delete from  public.instance_depart;

delete from  public.instance_detail;

delete from  public.instance_main;

delete from  public.order_log;

delete from public.idc_main_statistics;

delete from  public.idc_instance;

delete from public.role;

delete from public.indicator where idc_year<> 2019101;


delete from public.indicator_version where idc_version<>2019101;

insert into dictitonary(dictionary_id,item_value,item_code,group_key,item_describe,valid) values
('8812', 'http://124.196.4.219:8092', 'SSO_URL','SSO_URL','单点登录地址','1');