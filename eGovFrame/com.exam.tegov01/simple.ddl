/**********************************/
/* Table Name: IDS */
/**********************************/
CREATE TABLE IDS(
		TABLE_NAME                    		VARCHAR(20)		 NOT NULL COMMENT 'TABLE_NAME',
		NEXT_ID                       		DECIMAL(30)		 NOT NULL COMMENT 'NEXT_ID'
) COMMENT='IDS';

/**********************************/
/* Table Name: LETTCCMMNCLCODE */
/**********************************/
CREATE TABLE LETTCCMMNCLCODE(
		CL_CODE                       		CHAR(3)		 NOT NULL COMMENT 'CL_CODE',
		CL_CODE_NM                    		VARCHAR(60)		 NULL  COMMENT 'CL_CODE_NM',
		CL_CODE_DC                    		VARCHAR(200)		 NULL  COMMENT 'CL_CODE_DC',
		USE_AT                        		CHAR(1)		 NULL  COMMENT 'USE_AT',
		FRST_REGIST_PNTTM             		DATETIME		 NULL  COMMENT 'FRST_REGIST_PNTTM',
		FRST_REGISTER_ID              		VARCHAR(20)		 NULL  COMMENT 'FRST_REGISTER_ID',
		LAST_UPDT_PNTTM               		DATETIME		 NULL  COMMENT 'LAST_UPDT_PNTTM',
		LAST_UPDUSR_ID                		VARCHAR(20)		 NULL  COMMENT 'LAST_UPDUSR_ID'
) COMMENT='LETTCCMMNCLCODE';

/**********************************/
/* Table Name: LETTCCMMNCODE */
/**********************************/
CREATE TABLE LETTCCMMNCODE(
		CODE_ID                       		VARCHAR(6)		 NOT NULL COMMENT 'CODE_ID',
		CODE_ID_NM                    		VARCHAR(60)		 NULL  COMMENT 'CODE_ID_NM',
		CODE_ID_DC                    		VARCHAR(200)		 NULL  COMMENT 'CODE_ID_DC',
		USE_AT                        		CHAR(1)		 NULL  COMMENT 'USE_AT',
		CL_CODE                       		CHAR(3)		 NULL  COMMENT 'CL_CODE',
		FRST_REGIST_PNTTM             		DATETIME		 NULL  COMMENT 'FRST_REGIST_PNTTM',
		FRST_REGISTER_ID              		VARCHAR(20)		 NULL  COMMENT 'FRST_REGISTER_ID',
		LAST_UPDT_PNTTM               		DATETIME		 NULL  COMMENT 'LAST_UPDT_PNTTM',
		LAST_UPDUSR_ID                		VARCHAR(20)		 NULL  COMMENT 'LAST_UPDUSR_ID'
) COMMENT='LETTCCMMNCODE';

/**********************************/
/* Table Name: LETTCCMMNDETAILCODE */
/**********************************/
CREATE TABLE LETTCCMMNDETAILCODE(
		CODE_ID                       		VARCHAR(6)		 NOT NULL COMMENT 'CODE_ID',
		CODE                          		VARCHAR(15)		 NOT NULL COMMENT 'CODE',
		CODE_NM                       		VARCHAR(60)		 NULL  COMMENT 'CODE_NM',
		CODE_DC                       		VARCHAR(200)		 NULL  COMMENT 'CODE_DC',
		USE_AT                        		CHAR(1)		 NULL  COMMENT 'USE_AT',
		FRST_REGIST_PNTTM             		DATETIME		 NULL  COMMENT 'FRST_REGIST_PNTTM',
		FRST_REGISTER_ID              		VARCHAR(20)		 NULL  COMMENT 'FRST_REGISTER_ID',
		LAST_UPDT_PNTTM               		DATETIME		 NULL  COMMENT 'LAST_UPDT_PNTTM',
		LAST_UPDUSR_ID                		VARCHAR(20)		 NULL  COMMENT 'LAST_UPDUSR_ID'
) COMMENT='LETTCCMMNDETAILCODE';

/**********************************/
/* Table Name: LETTNAUTHORGROUPINFO */
/**********************************/
CREATE TABLE LETTNAUTHORGROUPINFO(
		GROUP_ID                      		CHAR(20)		 NOT NULL COMMENT 'GROUP_ID',
		GROUP_NM                      		VARCHAR(60)		 NOT NULL COMMENT 'GROUP_NM',
		GROUP_CREAT_DE                		CHAR(20)		 NOT NULL COMMENT 'GROUP_CREAT_DE',
		GROUP_DC                      		VARCHAR(100)		 NULL  COMMENT 'GROUP_DC'
) COMMENT='LETTNAUTHORGROUPINFO';

/**********************************/
/* Table Name: LETTNBBS */
/**********************************/
CREATE TABLE LETTNBBS(
		NTT_ID                        		DECIMAL(20)		 NOT NULL COMMENT 'NTT_ID',
		BBS_ID                        		CHAR(20)		 NOT NULL COMMENT 'BBS_ID',
		NTT_NO                        		DECIMAL(20)		 NULL  COMMENT 'NTT_NO',
		NTT_SJ                        		VARCHAR(2000)		 NULL  COMMENT 'NTT_SJ',
		NTT_CN                        		MEDIUMTEXT		 NULL  COMMENT 'NTT_CN',
		ANSWER_AT                     		CHAR(1)		 NULL  COMMENT 'ANSWER_AT',
		PARNTSCTT_NO                  		DECIMAL(10)		 NULL  COMMENT 'PARNTSCTT_NO',
		ANSWER_LC                     		INT(10)		 NULL  COMMENT 'ANSWER_LC',
		SORT_ORDR                     		DECIMAL(8)		 NULL  COMMENT 'SORT_ORDR',
		RDCNT                         		DECIMAL(10)		 NULL  COMMENT 'RDCNT',
		USE_AT                        		CHAR(1)		 NOT NULL COMMENT 'USE_AT',
		NTCE_BGNDE                    		CHAR(20)		 NULL  COMMENT 'NTCE_BGNDE',
		NTCE_ENDDE                    		CHAR(20)		 NULL  COMMENT 'NTCE_ENDDE',
		NTCR_ID                       		VARCHAR(20)		 NULL  COMMENT 'NTCR_ID',
		NTCR_NM                       		VARCHAR(20)		 NULL  COMMENT 'NTCR_NM',
		PASSWORD                      		VARCHAR(200)		 NULL  COMMENT 'PASSWORD',
		ATCH_FILE_ID                  		CHAR(20)		 NULL  COMMENT 'ATCH_FILE_ID',
		FRST_REGIST_PNTTM             		DATETIME		 NOT NULL COMMENT 'FRST_REGIST_PNTTM',
		FRST_REGISTER_ID              		VARCHAR(20)		 NOT NULL COMMENT 'FRST_REGISTER_ID',
		LAST_UPDT_PNTTM               		DATETIME		 NULL  COMMENT 'LAST_UPDT_PNTTM',
		LAST_UPDUSR_ID                		VARCHAR(20)		 NULL  COMMENT 'LAST_UPDUSR_ID'
) COMMENT='LETTNBBS';

/**********************************/
/* Table Name: LETTNBBSMASTER */
/**********************************/
CREATE TABLE LETTNBBSMASTER(
		BBS_ID                        		CHAR(20)		 NOT NULL COMMENT 'BBS_ID',
		BBS_NM                        		VARCHAR(255)		 NOT NULL COMMENT 'BBS_NM',
		BBS_INTRCN                    		VARCHAR(2400)		 NULL  COMMENT 'BBS_INTRCN',
		BBS_TY_CODE                   		CHAR(6)		 NOT NULL COMMENT 'BBS_TY_CODE',
		BBS_ATTRB_CODE                		CHAR(6)		 NOT NULL COMMENT 'BBS_ATTRB_CODE',
		REPLY_POSBL_AT                		CHAR(1)		 NULL  COMMENT 'REPLY_POSBL_AT',
		FILE_ATCH_POSBL_AT            		CHAR(1)		 NOT NULL COMMENT 'FILE_ATCH_POSBL_AT',
		ATCH_POSBL_FILE_NUMBER        		DECIMAL(2)		 NOT NULL COMMENT 'ATCH_POSBL_FILE_NUMBER',
		ATCH_POSBL_FILE_SIZE          		DECIMAL(8)		 NULL  COMMENT 'ATCH_POSBL_FILE_SIZE',
		USE_AT                        		CHAR(1)		 NOT NULL COMMENT 'USE_AT',
		TMPLAT_ID                     		CHAR(20)		 NULL  COMMENT 'TMPLAT_ID',
		FRST_REGISTER_ID              		VARCHAR(20)		 NOT NULL COMMENT 'FRST_REGISTER_ID',
		FRST_REGIST_PNTTM             		DATETIME		 NOT NULL COMMENT 'FRST_REGIST_PNTTM',
		LAST_UPDUSR_ID                		VARCHAR(20)		 NULL  COMMENT 'LAST_UPDUSR_ID',
		LAST_UPDT_PNTTM               		DATETIME		 NULL  COMMENT 'LAST_UPDT_PNTTM'
) COMMENT='LETTNBBSMASTER';

/**********************************/
/* Table Name: LETTNBBSMASTEROPTN */
/**********************************/
CREATE TABLE LETTNBBSMASTEROPTN(
		BBS_ID                        		CHAR(20)		 NOT NULL COMMENT 'BBS_ID',
		ANSWER_AT                     		CHAR(1)		 NOT NULL COMMENT 'ANSWER_AT',
		STSFDG_AT                     		CHAR(1)		 NOT NULL COMMENT 'STSFDG_AT',
		FRST_REGIST_PNTTM             		DATETIME		 NOT NULL COMMENT 'FRST_REGIST_PNTTM',
		LAST_UPDT_PNTTM               		DATETIME		 NULL  COMMENT 'LAST_UPDT_PNTTM',
		FRST_REGISTER_ID              		VARCHAR(20)		 NOT NULL COMMENT 'FRST_REGISTER_ID',
		LAST_UPDUSR_ID                		VARCHAR(20)		 NULL  COMMENT 'LAST_UPDUSR_ID'
) COMMENT='LETTNBBSMASTEROPTN';

/**********************************/
/* Table Name: LETTNBBSUSE */
/**********************************/
CREATE TABLE LETTNBBSUSE(
		BBS_ID                        		CHAR(20)		 NOT NULL COMMENT 'BBS_ID',
		TRGET_ID                      		CHAR(20)		 NOT NULL COMMENT 'TRGET_ID',
		USE_AT                        		CHAR(1)		 NOT NULL COMMENT 'USE_AT',
		REGIST_SE_CODE                		CHAR(6)		 NULL  COMMENT 'REGIST_SE_CODE',
		FRST_REGIST_PNTTM             		DATETIME		 NULL  COMMENT 'FRST_REGIST_PNTTM',
		FRST_REGISTER_ID              		VARCHAR(20)		 NOT NULL COMMENT 'FRST_REGISTER_ID',
		LAST_UPDT_PNTTM               		DATETIME		 NULL  COMMENT 'LAST_UPDT_PNTTM',
		LAST_UPDUSR_ID                		VARCHAR(20)		 NULL  COMMENT 'LAST_UPDUSR_ID'
) COMMENT='LETTNBBSUSE';

/**********************************/
/* Table Name: LETTNEMPLYRINFO */
/**********************************/
CREATE TABLE LETTNEMPLYRINFO(
		EMPLYR_ID                     		VARCHAR(20)		 NOT NULL COMMENT 'EMPLYR_ID',
		ORGNZT_ID                     		CHAR(20)		 NULL  COMMENT 'ORGNZT_ID',
		USER_NM                       		VARCHAR(60)		 NOT NULL COMMENT 'USER_NM',
		PASSWORD                      		VARCHAR(200)		 NOT NULL COMMENT 'PASSWORD',
		EMPL_NO                       		VARCHAR(20)		 NULL  COMMENT 'EMPL_NO',
		IHIDNUM                       		VARCHAR(200)		 NULL  COMMENT 'IHIDNUM',
		SEXDSTN_CODE                  		CHAR(1)		 NULL  COMMENT 'SEXDSTN_CODE',
		BRTHDY                        		CHAR(20)		 NULL  COMMENT 'BRTHDY',
		FXNUM                         		VARCHAR(20)		 NULL  COMMENT 'FXNUM',
		HOUSE_ADRES                   		VARCHAR(100)		 NULL  COMMENT 'HOUSE_ADRES',
		PASSWORD_HINT                 		VARCHAR(100)		 NOT NULL COMMENT 'PASSWORD_HINT',
		PASSWORD_CNSR                 		VARCHAR(100)		 NOT NULL COMMENT 'PASSWORD_CNSR',
		HOUSE_END_TELNO               		VARCHAR(4)		 NULL  COMMENT 'HOUSE_END_TELNO',
		AREA_NO                       		VARCHAR(4)		 NULL  COMMENT 'AREA_NO',
		DETAIL_ADRES                  		VARCHAR(100)		 NULL  COMMENT 'DETAIL_ADRES',
		ZIP                           		VARCHAR(6)		 NULL  COMMENT 'ZIP',
		OFFM_TELNO                    		VARCHAR(20)		 NULL  COMMENT 'OFFM_TELNO',
		MBTLNUM                       		VARCHAR(20)		 NULL  COMMENT 'MBTLNUM',
		EMAIL_ADRES                   		VARCHAR(50)		 NULL  COMMENT 'EMAIL_ADRES',
		OFCPS_NM                      		VARCHAR(60)		 NULL  COMMENT 'OFCPS_NM',
		HOUSE_MIDDLE_TELNO            		VARCHAR(4)		 NULL  COMMENT 'HOUSE_MIDDLE_TELNO',
		GROUP_ID                      		CHAR(20)		 NULL  COMMENT 'GROUP_ID',
		PSTINST_CODE                  		CHAR(8)		 NULL  COMMENT 'PSTINST_CODE',
		EMPLYR_STTUS_CODE             		VARCHAR(15)		 NOT NULL COMMENT 'EMPLYR_STTUS_CODE',
		ESNTL_ID                      		CHAR(20)		 NOT NULL COMMENT 'ESNTL_ID',
		CRTFC_DN_VALUE                		VARCHAR(20)		 NULL  COMMENT 'CRTFC_DN_VALUE',
		SBSCRB_DE                     		DATETIME		 NULL  COMMENT 'SBSCRB_DE'
) COMMENT='LETTNEMPLYRINFO';

/**********************************/
/* Table Name: LETTNENTRPRSMBER */
/**********************************/
CREATE TABLE LETTNENTRPRSMBER(
		ENTRPRS_MBER_ID               		VARCHAR(20)		 NOT NULL COMMENT 'ENTRPRS_MBER_ID',
		ENTRPRS_SE_CODE               		CHAR(15)		 NULL  COMMENT 'ENTRPRS_SE_CODE',
		BIZRNO                        		VARCHAR(10)		 NULL  COMMENT 'BIZRNO',
		JURIRNO                       		VARCHAR(13)		 NULL  COMMENT 'JURIRNO',
		CMPNY_NM                      		VARCHAR(60)		 NOT NULL COMMENT 'CMPNY_NM',
		CXFC                          		VARCHAR(50)		 NULL  COMMENT 'CXFC',
		ZIP                           		VARCHAR(6)		 NULL  COMMENT 'ZIP',
		ADRES                         		VARCHAR(100)		 NULL  COMMENT 'ADRES',
		ENTRPRS_MIDDLE_TELNO          		VARCHAR(4)		 NULL  COMMENT 'ENTRPRS_MIDDLE_TELNO',
		FXNUM                         		VARCHAR(20)		 NULL  COMMENT 'FXNUM',
		INDUTY_CODE                   		CHAR(15)		 NULL  COMMENT 'INDUTY_CODE',
		APPLCNT_NM                    		VARCHAR(50)		 NOT NULL COMMENT 'APPLCNT_NM',
		APPLCNT_IHIDNUM               		VARCHAR(200)		 NULL  COMMENT 'APPLCNT_IHIDNUM',
		SBSCRB_DE                     		DATETIME		 NULL  COMMENT 'SBSCRB_DE',
		ENTRPRS_MBER_STTUS            		VARCHAR(15)		 NULL  COMMENT 'ENTRPRS_MBER_STTUS',
		ENTRPRS_MBER_PASSWORD         		VARCHAR(200)		 NOT NULL COMMENT 'ENTRPRS_MBER_PASSWORD',
		ENTRPRS_MBER_PASSWORD_HINT    		VARCHAR(100)		 NOT NULL COMMENT 'ENTRPRS_MBER_PASSWORD_HINT',
		ENTRPRS_MBER_PASSWORD_CNSR    		VARCHAR(100)		 NOT NULL COMMENT 'ENTRPRS_MBER_PASSWORD_CNSR',
		GROUP_ID                      		CHAR(20)		 NULL  COMMENT 'GROUP_ID',
		DETAIL_ADRES                  		VARCHAR(100)		 NULL  COMMENT 'DETAIL_ADRES',
		ENTRPRS_END_TELNO             		VARCHAR(4)		 NULL  COMMENT 'ENTRPRS_END_TELNO',
		AREA_NO                       		VARCHAR(4)		 NULL  COMMENT 'AREA_NO',
		APPLCNT_EMAIL_ADRES           		VARCHAR(50)		 NULL  COMMENT 'APPLCNT_EMAIL_ADRES',
		ESNTL_ID                      		CHAR(20)		 NOT NULL COMMENT 'ESNTL_ID'
) COMMENT='LETTNENTRPRSMBER';

/**********************************/
/* Table Name: LETTNFILE */
/**********************************/
CREATE TABLE LETTNFILE(
		ATCH_FILE_ID                  		CHAR(20)		 NOT NULL COMMENT 'ATCH_FILE_ID',
		CREAT_DT                      		DATETIME		 NOT NULL COMMENT 'CREAT_DT',
		USE_AT                        		CHAR(1)		 NULL  COMMENT 'USE_AT'
) COMMENT='LETTNFILE';

/**********************************/
/* Table Name: LETTNFILEDETAIL */
/**********************************/
CREATE TABLE LETTNFILEDETAIL(
		ATCH_FILE_ID                  		CHAR(20)		 NOT NULL COMMENT 'ATCH_FILE_ID',
		FILE_SN                       		DECIMAL(10)		 NOT NULL COMMENT 'FILE_SN',
		FILE_STRE_COURS               		VARCHAR(2000)		 NOT NULL COMMENT 'FILE_STRE_COURS',
		STRE_FILE_NM                  		VARCHAR(255)		 NOT NULL COMMENT 'STRE_FILE_NM',
		ORIGNL_FILE_NM                		VARCHAR(255)		 NULL  COMMENT 'ORIGNL_FILE_NM',
		FILE_EXTSN                    		VARCHAR(20)		 NOT NULL COMMENT 'FILE_EXTSN',
		FILE_CN                       		MEDIUMTEXT		 NULL  COMMENT 'FILE_CN',
		FILE_SIZE                     		DECIMAL(8)		 NULL  COMMENT 'FILE_SIZE'
) COMMENT='LETTNFILEDETAIL';

/**********************************/
/* Table Name: LETTNGNRLMBER */
/**********************************/
CREATE TABLE LETTNGNRLMBER(
		MBER_ID                       		VARCHAR(20)		 NOT NULL COMMENT 'MBER_ID',
		PASSWORD                      		VARCHAR(200)		 NOT NULL COMMENT 'PASSWORD',
		PASSWORD_HINT                 		VARCHAR(100)		 NOT NULL COMMENT 'PASSWORD_HINT',
		PASSWORD_CNSR                 		VARCHAR(100)		 NOT NULL COMMENT 'PASSWORD_CNSR',
		IHIDNUM                       		VARCHAR(200)		 NULL  COMMENT 'IHIDNUM',
		MBER_NM                       		VARCHAR(50)		 NOT NULL COMMENT 'MBER_NM',
		ZIP                           		VARCHAR(6)		 NULL  COMMENT 'ZIP',
		ADRES                         		VARCHAR(100)		 NULL  COMMENT 'ADRES',
		AREA_NO                       		VARCHAR(4)		 NULL  COMMENT 'AREA_NO',
		MBER_STTUS                    		VARCHAR(15)		 NULL  COMMENT 'MBER_STTUS',
		DETAIL_ADRES                  		VARCHAR(100)		 NULL  COMMENT 'DETAIL_ADRES',
		END_TELNO                     		VARCHAR(4)		 NULL  COMMENT 'END_TELNO',
		MBTLNUM                       		VARCHAR(20)		 NULL  COMMENT 'MBTLNUM',
		GROUP_ID                      		CHAR(20)		 NULL  COMMENT 'GROUP_ID',
		MBER_FXNUM                    		VARCHAR(20)		 NULL  COMMENT 'MBER_FXNUM',
		MBER_EMAIL_ADRES              		VARCHAR(50)		 NULL  COMMENT 'MBER_EMAIL_ADRES',
		MIDDLE_TELNO                  		VARCHAR(4)		 NULL  COMMENT 'MIDDLE_TELNO',
		SBSCRB_DE                     		DATETIME		 NULL  COMMENT 'SBSCRB_DE',
		SEXDSTN_CODE                  		CHAR(1)		 NULL  COMMENT 'SEXDSTN_CODE',
		ESNTL_ID                      		CHAR(20)		 NOT NULL COMMENT 'ESNTL_ID'
) COMMENT='LETTNGNRLMBER';

/**********************************/
/* Table Name: LETTNORGNZTINFO */
/**********************************/
CREATE TABLE LETTNORGNZTINFO(
		ORGNZT_ID                     		CHAR(20)		 NOT NULL COMMENT 'ORGNZT_ID',
		ORGNZT_NM                     		VARCHAR(20)		 NOT NULL COMMENT 'ORGNZT_NM',
		ORGNZT_DC                     		VARCHAR(100)		 NULL  COMMENT 'ORGNZT_DC'
) COMMENT='LETTNORGNZTINFO';

/**********************************/
/* Table Name: LETTNSCHDULINFO */
/**********************************/
CREATE TABLE LETTNSCHDULINFO(
		SCHDUL_ID                     		CHAR(20)		 NOT NULL COMMENT 'SCHDUL_ID',
		SCHDUL_SE                     		CHAR(1)		 NULL  COMMENT 'SCHDUL_SE',
		SCHDUL_DEPT_ID                		VARCHAR(20)		 NULL  COMMENT 'SCHDUL_DEPT_ID',
		SCHDUL_KND_CODE               		VARCHAR(20)		 NULL  COMMENT 'SCHDUL_KND_CODE',
		SCHDUL_BEGINDE                		DATETIME		 NULL  COMMENT 'SCHDUL_BEGINDE',
		SCHDUL_ENDDE                  		DATETIME		 NULL  COMMENT 'SCHDUL_ENDDE',
		SCHDUL_NM                     		VARCHAR(255)		 NULL  COMMENT 'SCHDUL_NM',
		SCHDUL_CN                     		VARCHAR(2500)		 NULL  COMMENT 'SCHDUL_CN',
		SCHDUL_PLACE                  		VARCHAR(255)		 NULL  COMMENT 'SCHDUL_PLACE',
		SCHDUL_IPCR_CODE              		CHAR(1)		 NULL  COMMENT 'SCHDUL_IPCR_CODE',
		SCHDUL_CHARGER_ID             		VARCHAR(20)		 NULL  COMMENT 'SCHDUL_CHARGER_ID',
		ATCH_FILE_ID                  		CHAR(20)		 NULL  COMMENT 'ATCH_FILE_ID',
		FRST_REGIST_PNTTM             		DATETIME		 NULL  COMMENT 'FRST_REGIST_PNTTM',
		FRST_REGISTER_ID              		VARCHAR(20)		 NULL  COMMENT 'FRST_REGISTER_ID',
		LAST_UPDT_PNTTM               		DATETIME		 NULL  COMMENT 'LAST_UPDT_PNTTM',
		LAST_UPDUSR_ID                		VARCHAR(20)		 NULL  COMMENT 'LAST_UPDUSR_ID',
		REPTIT_SE_CODE                		CHAR(3)		 NULL  COMMENT 'REPTIT_SE_CODE'
) COMMENT='LETTNSCHDULINFO';

/**********************************/
/* Table Name: LETTNTMPLATINFO */
/**********************************/
CREATE TABLE LETTNTMPLATINFO(
		TMPLAT_ID                     		CHAR(20)		 NOT NULL COMMENT 'TMPLAT_ID',
		TMPLAT_NM                     		VARCHAR(255)		 NULL  COMMENT 'TMPLAT_NM',
		TMPLAT_COURS                  		VARCHAR(2000)		 NULL  COMMENT 'TMPLAT_COURS',
		USE_AT                        		CHAR(1)		 NULL  COMMENT 'USE_AT',
		TMPLAT_SE_CODE                		CHAR(6)		 NULL  COMMENT 'TMPLAT_SE_CODE',
		FRST_REGISTER_ID              		VARCHAR(20)		 NULL  COMMENT 'FRST_REGISTER_ID',
		FRST_REGIST_PNTTM             		DATETIME		 NULL  COMMENT 'FRST_REGIST_PNTTM',
		LAST_UPDUSR_ID                		VARCHAR(20)		 NULL  COMMENT 'LAST_UPDUSR_ID',
		LAST_UPDT_PNTTM               		DATETIME		 NULL  COMMENT 'LAST_UPDT_PNTTM'
) COMMENT='LETTNTMPLATINFO';


ALTER TABLE IDS ADD CONSTRAINT IDX_IDS_PK PRIMARY KEY (TABLE_NAME);

ALTER TABLE LETTCCMMNCLCODE ADD CONSTRAINT IDX_LETTCCMMNCLCODE_PK PRIMARY KEY (CL_CODE);

ALTER TABLE LETTCCMMNCODE ADD CONSTRAINT IDX_LETTCCMMNCODE_PK PRIMARY KEY (CODE_ID);
CREATE INDEX R_179 ON LETTCCMMNCODE (CL_CODE);

ALTER TABLE LETTCCMMNDETAILCODE ADD CONSTRAINT IDX_LETTCCMMNDETAILCODE_PK PRIMARY KEY (CODE_ID, CODE);

ALTER TABLE LETTNAUTHORGROUPINFO ADD CONSTRAINT IDX_LETTNAUTHORGROUPINFO_PK PRIMARY KEY (GROUP_ID);

ALTER TABLE LETTNBBS ADD CONSTRAINT IDX_LETTNBBS_PK PRIMARY KEY (NTT_ID, BBS_ID);
CREATE INDEX LETTNBBS_ibfk_1 ON LETTNBBS (BBS_ID);

ALTER TABLE LETTNBBSMASTER ADD CONSTRAINT IDX_LETTNBBSMASTER_PK PRIMARY KEY (BBS_ID);

ALTER TABLE LETTNBBSMASTEROPTN ADD CONSTRAINT IDX_LETTNBBSMASTEROPTN_PK PRIMARY KEY (BBS_ID);

ALTER TABLE LETTNBBSUSE ADD CONSTRAINT IDX_LETTNBBSUSE_PK PRIMARY KEY (BBS_ID, TRGET_ID);

ALTER TABLE LETTNEMPLYRINFO ADD CONSTRAINT IDX_LETTNEMPLYRINFO_PK PRIMARY KEY (EMPLYR_ID);
CREATE INDEX LETTNEMPLYRINFO_ibfk_1 ON LETTNEMPLYRINFO (ORGNZT_ID);
CREATE INDEX LETTNEMPLYRINFO_ibfk_2 ON LETTNEMPLYRINFO (GROUP_ID);

ALTER TABLE LETTNENTRPRSMBER ADD CONSTRAINT IDX_LETTNENTRPRSMBER_PK PRIMARY KEY (ENTRPRS_MBER_ID);
CREATE INDEX LETTNENTRPRSMBER_ibfk_1 ON LETTNENTRPRSMBER (GROUP_ID);

ALTER TABLE LETTNFILE ADD CONSTRAINT IDX_LETTNFILE_PK PRIMARY KEY (ATCH_FILE_ID);

ALTER TABLE LETTNFILEDETAIL ADD CONSTRAINT IDX_LETTNFILEDETAIL_PK PRIMARY KEY (ATCH_FILE_ID, FILE_SN);

ALTER TABLE LETTNGNRLMBER ADD CONSTRAINT IDX_LETTNGNRLMBER_PK PRIMARY KEY (MBER_ID);
CREATE INDEX LETTNGNRLMBER_ibfk_1 ON LETTNGNRLMBER (GROUP_ID);

ALTER TABLE LETTNORGNZTINFO ADD CONSTRAINT IDX_LETTNORGNZTINFO_PK PRIMARY KEY (ORGNZT_ID);

ALTER TABLE LETTNSCHDULINFO ADD CONSTRAINT IDX_LETTNSCHDULINFO_PK PRIMARY KEY (SCHDUL_ID);

ALTER TABLE LETTNTMPLATINFO ADD CONSTRAINT IDX_LETTNTMPLATINFO_PK PRIMARY KEY (TMPLAT_ID);

