--增加表
CREATE TABLE "public"."indicator_register" (
"idc_id" varchar(20) NOT NULL,
"idc_extend_id" varchar(20) NOT NULL,
"register_date" int4 NOT NULL,
"idc_value" varchar(200),
"idc_score" varchar(200),
"idc_base" varchar(200),
"create_time" timestamp(6),
"update_time" timestamp(6),
"oper_code" varchar(20),
"oper_name" varchar(20),
"modifyer_code" varchar(20),
"modifyer_name" varchar(20),
"valid" varchar(2),
"hospital_id" varchar(20),
CONSTRAINT "indicator_register_pkey" PRIMARY KEY ("idc_id")
)
WITH (OIDS=FALSE)
;

ALTER TABLE "public"."indicator_register" OWNER TO "postgres";

COMMENT ON TABLE "public"."indicator_register" IS '指标登记表';

COMMENT ON COLUMN "public"."indicator_register"."idc_id" IS '主键id';

COMMENT ON COLUMN "public"."indicator_register"."idc_extend_id" IS '指标扩展id';

COMMENT ON COLUMN "public"."indicator_register"."register_date" IS '登记日期';

COMMENT ON COLUMN "public"."indicator_register"."idc_value" IS '指标结果';

COMMENT ON COLUMN "public"."indicator_register"."idc_score" IS '指标得分';

COMMENT ON COLUMN "public"."indicator_register"."idc_base" IS '指标基准值';

COMMENT ON COLUMN "public"."indicator_register"."create_time" IS '创建时间';

COMMENT ON COLUMN "public"."indicator_register"."update_time" IS '修改时间';

COMMENT ON COLUMN "public"."indicator_register"."oper_code" IS '操作员编号';

COMMENT ON COLUMN "public"."indicator_register"."oper_name" IS '操作员姓名';

COMMENT ON COLUMN "public"."indicator_register"."modifyer_code" IS '修改人编号';

COMMENT ON COLUMN "public"."indicator_register"."modifyer_name" IS '修改人姓名';

COMMENT ON COLUMN "public"."indicator_register"."valid" IS '软删除  1有效 0 删除';

COMMENT ON COLUMN "public"."indicator_register"."hospital_id" IS '医院id';


alter table public.indicator_extend add column written_level varchar(20);

COMMENT ON COLUMN public.indicator_extend.written_level IS '填报层级';

--修改配置表值
UPDATE "public".idc_view_config set idc_final='18' where idc_code='HSP_QL_B_18';
UPDATE "public".idc_view_config set idc_final='19' where idc_code='HSP_QL_B_19';


--增加列
alter table public.role add column finally_user varchar(200);
COMMENT ON COLUMN public.role.finally_user
    IS '最终审批人';

alter table public.role add column look_user varchar(200);
COMMENT ON COLUMN public.role.look_user
    IS '查看人';

alter table public.role add column finally_permission varchar(2) not null DEFAULT 'N';
COMMENT ON COLUMN public.role.finally_permission
    IS '最终审批人审批权（Y-有，N-无）';

alter table public.role add column finally_dep varchar(50);
COMMENT ON COLUMN public.role.finally_dep
    IS '终审科室';

--增加索引
CREATE INDEX idcId_index ON indicator_extend (idc_id);
CREATE INDEX idc_year_index ON indicator (idc_year);