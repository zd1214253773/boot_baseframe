alter table public.indicator drop column idc_reference_value;
alter table public.indicator add column idc_reference_value varchar(30);
COMMENT ON COLUMN "public"."indicator"."idc_reference_value" IS '基线值';