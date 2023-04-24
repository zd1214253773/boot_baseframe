update public.indicator_extend set wirtten_depart ='10001' where wirtten_depart = 'FUNCTION_CWK';
update public.indicator_extend set audit_depart ='10001' where audit_depart = 'FUNCTION_CWK';

update public.indicator_extend set wirtten_depart ='20006' where wirtten_depart = 'FUNCTION_YXB';
update public.indicator_extend set audit_depart ='20006' where audit_depart = 'FUNCTION_YXB';

--update public.indicator_extend set wirtten_depart ='70003' where wirtten_depart = 'FUNCTION_SBK';
--update public.indicator_extend set audit_depart ='70003' where audit_depart = 'FUNCTION_SBK';

update public.indicator_extend set wirtten_depart ='70002' where wirtten_depart = 'FUNCTION_HLB';
update public.indicator_extend set audit_depart ='70002' where audit_depart = 'FUNCTION_HLB';

update public.indicator_extend set wirtten_depart ='70006' where wirtten_depart = 'FUNCTION_YWK';
update public.indicator_extend set audit_depart ='70006' where audit_depart = 'FUNCTION_YWK';

--update public.indicator_extend set wirtten_depart ='70003' where wirtten_depart = 'FUNCTION_ZKK';
--update public.indicator_extend set audit_depart ='70003' where audit_depart = 'FUNCTION_ZKK';

update public.indicator_extend set wirtten_depart ='70008' where wirtten_depart = 'FUNCTION_RSK';
update public.indicator_extend set audit_depart ='70008' where audit_depart = 'FUNCTION_RSK';

--修改oper_code、modifyer_code字段大小

CREATE or replace FUNCTION alterColumn(cloumnName VARCHAR(32), out v_retcode text)
AS
$BODY$
declare
row_data VARCHAR;
showSql VARCHAR;
i INTEGER:=1;
intm INTEGER;

BEGIN
for row_data in select relname as tabname from pg_class c where relkind = 'r' and relname not like 'pg_%'
and relname not like 'sql_%' and relname not in('t_gtl_mini_program','t_gtl_customer_mini_program') order by relname LOOP
intm = (select count(*) from information_schema.columns where table_name =row_data and column_name=cloumnName);

raise notice 'Parameter is: %', intm;
if intm > 0 then
showSql = 'alter TABLE public.' || row_data ||' ALTER COLUMN ' || cloumnName ||' TYPE varchar(64)';
EXECUTE showSql;
raise notice 'Parameter is: %', showSql;
end if;
END LOOP;
END;
$BODY$
language plpgsql;

select * from alterColumn('oper_code');
select * from alterColumn('modifyer_code');
SELECT * from alterColumn('check_user_id');
SELECT * from alterColumn('user_id');




