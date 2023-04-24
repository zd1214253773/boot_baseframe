update indicator set idc_year=2020101 where idc_year=2020;
update indicator set idc_year=2019101 where idc_year=2019;
---CATEGORY_COU国标
---CATEGORY_COU("国标"),
    --CATEGORY_PRO("省标"),
    --CATEGORY_CITY("市标"),
    --CATEGORY_HOS("院标");
update dictitonary set item_code='101' where item_code='CATEGORY_COU';
update dictitonary set item_code='102' where item_code='CATEGORY_PRO';
update dictitonary set item_code='103' where item_code='CATEGORY_CITY';
update dictitonary set item_code='104' where item_code='CATEGORY_HOS';
--刷新数据
update indicator set idc_category='101' where idc_category='CATEGORY_COU';

update instance_main set indicator_version=2020101 where indicator_version=2020;
update instance_main set indicator_version=2019101 where indicator_version=2019;
update instance_main set indicator_version=2021101 where indicator_version=2021;

update instance_main set indicator_version=2020101 where indicator_version=2020;
update instance_main set indicator_version=2019101 where indicator_version=2019;
update instance_main set indicator_version=2021101 where indicator_version=2021;

update idc_view_config set data_version =2020101   where data_version=2020;

-----版本管理表
--增加表
CREATE TABLE "public"."indicator_version" (
"idc_version_id" varchar(20) NOT NULL,
"idc_category" varchar(20) NOT NULL,
"idc_year" int4 NOT NULL,
"idc_name" varchar(100) NOT NULL,
"idc_version" int4 NOT NULL,
"hospital_id" varchar(20),
"idc_remark" varchar(200),
"create_time" timestamp(6),
"update_time" timestamp(6),
"oper_code" varchar(20),
"oper_name" varchar(20),
"modifyer_code" varchar(20),
"modifyer_name" varchar(20),
"valid" varchar(2),
CONSTRAINT "indicator_version_pkey" PRIMARY KEY ("idc_version_id")
);

ALTER TABLE "public"."indicator_version" OWNER TO "postgres";

COMMENT ON TABLE "public"."indicator_version" IS '指标版本管理表';

COMMENT ON COLUMN "public"."indicator_version"."idc_version_id" IS '主键id';

COMMENT ON COLUMN "public"."indicator_version"."idc_category" IS '指标类别';

COMMENT ON COLUMN "public"."indicator_version"."idc_year" IS '指标年份';

COMMENT ON COLUMN "public"."indicator_version"."idc_version" IS '指标版本(年份+类别)';

COMMENT ON COLUMN "public"."indicator_version"."idc_name" IS '指标名称';

COMMENT ON COLUMN "public"."indicator_version"."idc_remark" IS '指标版本描述';

COMMENT ON COLUMN "public"."indicator_version"."hospital_id" IS '医院id';


COMMENT ON COLUMN "public"."indicator_version"."create_time" IS '创建时间';

COMMENT ON COLUMN "public"."indicator_version"."update_time" IS '修改时间';

COMMENT ON COLUMN "public"."indicator_version"."oper_code" IS '操作员编号';

COMMENT ON COLUMN "public"."indicator_version"."oper_name" IS '操作员姓名';

COMMENT ON COLUMN "public"."indicator_version"."modifyer_code" IS '修改人编号';

COMMENT ON COLUMN "public"."indicator_version"."modifyer_name" IS '修改人姓名';

COMMENT ON COLUMN "public"."indicator_version"."valid" IS '软删除  1有效 0 删除';


