--增加列
alter table public.topic_detail add column selected_flag boolean default false;

COMMENT ON COLUMN public.topic_detail.selected_flag
    IS '默认是否选中';

--增加时间筛选列
alter table public.topic add column time_filter_col_name varchar(50) not null default '1';
--
update public.topic set time_filter_col_name='workload_orddate';

COMMENT ON COLUMN public.topic.time_filter_col_name
    IS '主题时间筛选列';

--增加列
alter table public.topic_detail add column dime_type varchar(50);

COMMENT ON COLUMN public.topic_detail.dime_type
    IS '维度类别[TIME,UNIT]用于标识下钻链';


    alter table public.idc_main_statistics add column order_no varchar(50);