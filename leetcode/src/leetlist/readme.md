1、获取画像状态

1.1使用说明

方式	Get
url	http://logic.ad.mmbiz.oa.com/cgi-bin/userprofile/monitor/monitor_data
说明	测试环境host：10.123.98.23 logic.ad.mmbiz.oa.com
命令字(get)	userprofile_online_status：查询线上用户画像信息<br>userprofile_history_info：查询用户画像历史版本更新信息<br>
1.2 userprofile_online_status

参数名称	类型	描述	required
action	string	get_online_status:查询线上画像信息	yes
IDC	string	数据中心选择:shanghai,shenzhen	yes
{
    "ret": 0,
    "msg": "succ",
    "md_list": [
        {
            "code": 0,
            "IDC": "shanghai",
            "data_type": "commerce",
            "version": 20170718,
            "total_num": 718509871,
            "succ_num": 235632,
            "fail_num": 0,
            "start_time": 0,
            "speed": 325,
            "update_time": 1500993182271
        },
        {
            "code": 0,
            "IDC": "shanghai",
            "data_type": "commerce",
            "version": 20170718,
            "total_num": 718509871,
            "succ_num": 235632,
            "fail_num": 0,
            "start_time": 0,
            "speed": 325,
            "update_time": 1500993182271
        }
    ]
}
1.3 userprofile_history_info

参数名称	类型	描述	required
action	string	get_online_status:查询画像历史版本信息	yes
IDC	string	数据中心:shanghai,shenzhen	yes
data_type	string	数据维度: appbehavior，commerce，userextinfo，socialprofile，realuserinfo，userinfo_weekly	yes
{
    "ret": 0,
    "msg": "succ",
    "md_list": [
        {
            "code": 0,
            "IDC": "shanghai",
            "data_type": "commerce",
            "version": 20170718,
            "total_num": 718509871,
            "succ_num": 235632,
            "fail_num": 0,
            "start_time": 0,
            "speed": 325,
            "update_time": 1500993182271
        },
        {
            "code": 0,
            "IDC": "shanghai",
            "data_type": "commerce",
            "version": 20170718,
            "total_num": 718509871,
            "succ_num": 235632,
            "fail_num": 0,
            "start_time": 0,
            "speed": 325,
            "update_time": 1500993182271
        }
    ]
}
2、获取画像更新通道状态

2.1使用说明

方式	Get
url	http://logic.ad.mmbiz.oa.com/cgi-bin/userprofile/monitor/monitor_data
说明	测试环境host：10.123.98.23 logic.ad.mmbiz.oa.com
命令字(get)	tpg_status:查询画像更新通道信息 <br/> mq_status:查询画像更新通道信息<br/>mq_status_machine:查询某个用户画像维度在每台机器上的通道情况
2.2 tpg_status

参数名称	类型	描述	required
action	string	tpg_status:查询画像更新通道信息	yes
IDC	string	数据中心:shanghai,shenzhen	yes
{
    "ret": 0,
    "msg": "succ",
    "general_info": {
        "fail": 10,
        "pending": 814,
        "expire": 10
    },
    "pending_list": [
        {
            "data_type": "commerce",
            "version": 20170710,
            "num": 100
        },
        {
            "data_type": "appbehavior",
            "version": 20170710,
            "num": 10
        }
    ],
    "fail_list": [
        {
            "data_type": "commerce",
            "version": 20170710,
            "num": 100
        },
        {
            "data_type": "appbehavior",
            "version": 20170710,
            "num": 10
        }
    ],
    "expire_list": [
        {
            "data_type": "commerce",
            "version": 20170710,
            "num": 100
        },
        {
            "data_type": "appbehavior",
            "version": 20170710,
            "num": 10
        }
    ]
}
2.3mq_status

参数名称	类型	描述	required
action	string	mq_status:查询画像更新通道信息	yes
IDC	string	数据中心:shanghai,shenzhen	yes
{
    "ret": 0,
    "general_info": {
        "kv_speed": 1000,
        "pending": 200000,
        "mq_speed": 100000
    },
    "detail_list": [
        {
            "data_type": "commerce",
            "version": 20170718,
            "mq_speed": 20000,
            "kv_speed": 1000
        },
        {
            "data_type": "appbehavior",
            "version": 20170710,
            "mq_speed": 24000,
            "kv_speed": 2300
        }
    ]
}
2.4 mq_status_machine

参数名称	类型	描述	required
action	string	mq_status_machine:查询某个用户画像维度在每台机器上的通道情况	yes
IDC	string	数据中心:shanghai,shenzhen	yes
data_type	string	数据维度: appbehavior，commerce，userextinfo，socialprofile，realuserinfo，userinfo_weekly	yes
{
    "ret": 0,
    "msg": "succ",
    "detail_list": [
        {
            "version": 20170710,
            "hostname": "tencent64",
            "mq_speed": 2300,
            "kv_speed": 0
        },
        {
            "version": 20170716,
            "hostname": "mmocadmpweblogicsvr_11",
            "mq_speed": 2000,
            "kv_speed": 100
        }
    ]
}
