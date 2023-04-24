INSERT INTO public.topic(
	topic_id, topic_name, topic_code, topic_remark, source_table,  valid, parent_topic_code, time_filter_col_name)
	VALUES ('H6784912791', '收入统计', 'INCOME_CODE', '', 'etl_dhc_workload_no_inx', '1', null, 'workload_orddate');

--------度量项
INSERT INTO public.topic_detail(
	topic_detail_id, topic_code, use_type, sequence, child_format_topic_code, col_name, statics_type, valid, selected_flag, dime_type)
	VALUES ('H6784912791421', 'INCOME_CODE', 'METRIC', 1, null, 'workload_totalprice', 'SUM', '1',false, '');

INSERT INTO public.topic_detail(
	topic_detail_id, topic_code, use_type, sequence, child_format_topic_code, col_name, statics_type, valid, selected_flag, dime_type)
	VALUES ('H6784912791422', 'INCOME_CODE', 'METRIC', 2, null, 'workload_unitprice', 'SUM', '1',false, '');

INSERT INTO public.topic_detail(
	topic_detail_id, topic_code, use_type, sequence, child_format_topic_code, col_name, statics_type, valid, selected_flag, dime_type)
	VALUES ('H6784912791423', 'INCOME_CODE', 'METRIC', 3, null, 'workload_quantity', 'SUM', '1',false, '');



----维度项

	INSERT INTO public.topic_detail(
    	topic_detail_id, topic_code, use_type, sequence, child_format_topic_code, col_name, statics_type, valid, selected_flag, dime_type)
    	VALUES ('H6784912791424', 'INCOME_CODE', 'GROUP', 4, null, 'hosp_desc', '', '1',false, 'UNIT');

    	INSERT INTO public.topic_detail(
    	topic_detail_id, topic_code, use_type, sequence, child_format_topic_code, col_name, statics_type, valid, selected_flag, dime_type)
    	VALUES ('H6784912791425', 'INCOME_CODE', 'GROUP', 5, null, 'workload_type', '', '1',false, 'UNIT');

    	INSERT INTO public.topic_detail(
    	topic_detail_id, topic_code, use_type, sequence, child_format_topic_code, col_name, statics_type, valid, selected_flag, dime_type)
    	VALUES ('H6784912791427', 'INCOME_CODE', 'GROUP', 7, null, 'resdep_desc', '', '1',false, 'UNIT');



    		INSERT INTO public.topic_detail(
    	topic_detail_id, topic_code, use_type, sequence, child_format_topic_code, col_name, statics_type, valid, selected_flag, dime_type)
    	VALUES ('H6784912791429', 'INCOME_CODE', 'GROUP', 9, null, 'resdoc_desc', '', '1',false, 'UNIT');

-----字段字典


INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3123124523121', 'recdep_desc', '执行科室', '1');


	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3123124523122', 'resdep_desc', '开单科室', '1');


	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3123124523131', 'hosp_desc', '机构', '1');

	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3123124523132', 'workload_type', '门诊/住院分类', '1');


	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3123124523124', 'workload_orddate', '开单时间', '1');


	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3123124523125', 'workload_unitprice', '单价', '1');

	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3123124523126', 'workload_quantity', '数量', '1');

	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3123124523127', 'workload_totalprice', '总价', '1');

		INSERT INTO public.field_info(
    	field_info_id, col_name, label,valid)
    	VALUES ('H31231245231251', 'workload_unitprice_sum', '单价', '1');

    	INSERT INTO public.field_info(
    	field_info_id, col_name, label,valid)
    	VALUES ('H31231245231261', 'workload_quantity_sum', '数量', '1');

    	INSERT INTO public.field_info(
    	field_info_id, col_name, label,valid)
    	VALUES ('H31231245231271', 'workload_totalprice_sum', '总价', '1');

	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3123124523128', 'resdoc_desc', '开单医生', '1');
	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3123124523129', 'tari_desc', '收费细项', '1');
	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H4123124523124', 'patdep_desc', '就诊/所在科室', '1');


		INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H5123124523124', 'patdoc_desc', '接诊/管床医师', '1');
	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H6123124523124', 'workload_flagdate', '门诊交账日期', '1');
	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H7123124523124', 'tarac_desc', '收费项目会计子分类', '1');



			INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H8123124523124', 'tarsc_desc', '收费项目分类', '1');
	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H9123124523124', 'taroc_code', '门诊收据分类', '1');
	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3223124523124', 'tarac_desc', '收费项目会计子分类', '1');

				INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3323124523124', 'tarec_desc', '经济核算分类', '1');
	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3423124523124', 'workload_tarmc_dr', '病案首页费用分类', '1');
	INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3523124523124', 'taric_desc', '住院收据分类', '1');

		INSERT INTO public.field_info(
	field_info_id, col_name, label,valid)
	VALUES ('H3623124523124', 'workload_datatype', '账单类型', '1');




