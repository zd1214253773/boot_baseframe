ALTER  table instance_main ADD COLUMN task_warn_msg varchar(100) ;
COMMENT ON COLUMN "instance_main"."task_warn_msg" IS '任务提示信息';