CREATE TABLE "public"."item_config" (
"item_config_id" varchar(20) NOT NULL,
"item_code" varchar(20),
"idc_year" int4,
"item_url" varchar(256),
"parent_id" varchar(20),
"hospital_id" varchar(20),
"create_time" timestamp(6),
"update_time" timestamp(6),
"oper_code" varchar(64),
"oper_name" varchar(20),
"modifyer_name" varchar(20),
"modifyer_code" varchar(64),
"valid" varchar(2),
CONSTRAINT "item_config_pkey" PRIMARY KEY ("item_config_id")
)
WITH (OIDS=FALSE)
;


COMMENT ON COLUMN "public"."item_config"."item_config_id" IS '主键id';

COMMENT ON COLUMN "public"."item_config"."item_code" IS '编码';

COMMENT ON COLUMN "public"."item_config"."idc_year" IS '版本';

COMMENT ON COLUMN "public"."item_config"."item_url" IS '跳转url';

COMMENT ON COLUMN "public"."item_config"."parent_id" IS '上级节点';

COMMENT ON COLUMN "public"."item_config"."hospital_id" IS '医院id';

COMMENT ON COLUMN "public"."item_config"."create_time" IS '创建时间';

COMMENT ON COLUMN "public"."item_config"."update_time" IS '修改时间';

COMMENT ON COLUMN "public"."item_config"."oper_code" IS '操作员编号';

COMMENT ON COLUMN "public"."item_config"."oper_name" IS '操作人';

COMMENT ON COLUMN "public"."item_config"."modifyer_name" IS '修改人';

COMMENT ON COLUMN "public"."item_config"."modifyer_code" IS '修改人编号';

COMMENT ON COLUMN "public"."item_config"."valid" IS '软删除';


ALTER  table indicator_version ADD COLUMN reference_idc_version integer ;
COMMENT ON COLUMN "indicator_version"."reference_idc_version" IS '参考版本';