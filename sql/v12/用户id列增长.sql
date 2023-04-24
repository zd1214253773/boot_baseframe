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

#生产环境
UPDATE "public".dictitonary set item_value='http://172.16.33.175:8092' where group_key='MANAGER_ADDRESS';