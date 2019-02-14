 #SELECT  STR_TO_DATE(datestring,'%Y-%d-%m  %H:%i:%s'),date_format(STR_TO_DATE(datestring,'%Y-%d-%m %H:%i:%s'),'%Y-%d-%M') FROM scadaalarmsdb.scadadata3;
 # SELECT * FROM scadaalarmsdb.scadadata3;
#update scadaalarmsdb.scadadata3 set dates_new=date_format(STR_TO_DATE(datestring,'%Y-%d-%m %H:%i:%s'),'%Y-%m-%d');

SELECT * FROM scadaalarmsdb.scada2 where ddeitem like 'Frequency_Sarna' and dates like '2019-02-06' and times like '06%';

# 'Frequency_Sarna-BBPS.SCADA01.00296276-06:31:58-2019-02-06