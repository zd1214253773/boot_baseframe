

alter table public.indicator_extend add column written_level varchar(20);

COMMENT ON COLUMN public.indicator_extend.written_level IS '填报层级';


----增加字典值
INSERT INTO public.dictitonary(dictionary_id, parent_item__key, item_value, item_code, sequence, item_describe, group_key, valid)
	VALUES ('H98924394829808', null, '院级', 'WRITE_LEVEL_HOSPITAL', 1, null, 'WRITE_LEVEL','1');
INSERT INTO public.dictitonary(dictionary_id, parent_item__key, item_value, item_code, sequence, item_describe, group_key, valid)
	VALUES ('H98924394829810', null, '科级', 'WRITE_LEVEL_DEPART', 2, null, 'WRITE_LEVEL','1');