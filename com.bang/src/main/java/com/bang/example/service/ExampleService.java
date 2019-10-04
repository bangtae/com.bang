package com.bang.example.service;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.DestinationDataProvider;

import me.saro.sap.jco.SapFunction;
import me.saro.sap.jco.SapFunctionResult;
import me.saro.sap.jco.SapManager;
import me.saro.sap.jco.SapManagerBuilderOption;

@Service
public class ExampleService {
	private static final Log logger = LogFactory.getLog(ExampleService.class);

//	static String ABAP_MS = "ABAP_MS_WITHOUT_POOL";
//	static String ABAP_AS = "ABAP_AS_WITHOUT_POOL";

//	static {
//		Properties connectProperties = new Properties();
//
//		// SAP 개발, 품질서버일 경우
//		connectProperties.clear();
//		connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, ""); // SAP 호스트 정보
//		connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "00"); // SAP 시스템 넘버
//		connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "800"); // SAP Client 번호
//		connectProperties.setProperty(DestinationDataProvider.JCO_USER, ""); // SAP 아이디
//		connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "!"); // SAP 패스워드
//		connectProperties.setProperty(DestinationDataProvider.JCO_LANG, "EN"); // SAP 언어
//		createDataFile(ABAP_AS, "JCoDestination", connectProperties);

		// SAP 운영서버일 경우
//		connectProperties.clear();
//		connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "3"); // SAP Connection Pool 사이즈
//		connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "10");	//SAP Max Connection Pool 사이즈
//		connectProperties.setProperty(DestinationDataProvider.JCO_MSHOST, ""); // SAP 호스트 정보
//		connectProperties.setProperty(DestinationDataProvider.JCO_R3NAME, ""); // SAP 시스템명
//		connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "800"); // SAP Client 번호
//		connectProperties.setProperty(DestinationDataProvider.JCO_USER, ""); // SAP 아이디
//		connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, ""); // SAP 패스워드
//		connectProperties.setProperty(DestinationDataProvider.JCO_GROUP, ""); // SAP 로그온 그룹
//		connectProperties.setProperty(DestinationDataProvider.JCO_LANG, "EN"); // SAP 언어
//		createDataFile(ABAP_MS, "JCoDestination", connectProperties); // SAP 데스티네이션
		
//	}

//	static void createDataFile(String name, String suffix, Properties properties) {
//		File cfg = new File(name + "." + suffix);
//		if (!cfg.exists()) {
//			try {
//				FileOutputStream fos = new FileOutputStream(cfg, false);
//				properties.store(fos, "for tests only !");
//				fos.close();
//			} catch (Exception e) {
//				throw new RuntimeException("Unable to create the destination file " + cfg.getName(), e);
//			}
//		}
//	}
//	
//	public void jco() throws Exception {
//        JCoDestination destination = JCoDestinationManager.getDestination(ABAP_AS);
//        //Remote Function Module
//        JCoFunction function_parameter = destination.getRepository().getFunction("ZD_IDNO_CALCU_AGE");
//        JCoFunction function_table = destination.getRepository().getFunction("ZTEST_RFC_FIORI");
//        //Import Parameter
//        function_parameter.getImportParameterList().setValue("IDNO", "8411112345678");
//        //Import Table
//        JCoTable iTab = function_table.getTableParameterList().getTable("TBL_MARA");
//        iTab.appendRow();
//        iTab.setValue("MATNR", "23");
//        
//        if(function_parameter == null) 
//            throw new RuntimeException("ZD_IDNO_CALCU_AGE not found in SAP.");
//            
//        if(function_table == null) 
//            throw new RuntimeException("ZTEST_RFC_FIORI not found in SAP.");            
// 
//        try{
//            //Function Call
//        	function_parameter.execute(destination);
//        	function_table.execute(destination);
//        }catch(AbapException e){
//        	logger.debug(e.toString());
//            return;
//        }
//        //Exmport Parameter
//        logger.info(function_parameter.getExportParameterList().getValue("EAST_AGE"));
//        logger.info(function_parameter.getExportParameterList().getValue("WEST_AGE"));
//        //Export Table
//        JCoTable eTab = function_table.getTableParameterList().getTable("TBL_MARA");
//		for (int i = 0; i < eTab.getNumRows(); i++) {
//			eTab.setRow(i);
//			 logger.info(eTab.getString("MATNR"));
//			 logger.info(eTab.getString("MTART"));		
//		}
//	}
//	
//	/**
//	 * 참고 사이트: https://gs.saro.me/dev?page=5&tn=562
//	 */
//	public void jco1() throws JCoException, IOException {
//	    SapManager sap = SapManager
//	            .builder()
//	            .set(SapManagerBuilderOption.ASHOST, "")
//	            //.set(SapManagerBuilderOption.MSSERV, "")
//	            .set(SapManagerBuilderOption.SYSNR, "00")
//	            //.set(SapManagerBuilderOption.GROUP, "")
//	            .set(SapManagerBuilderOption.LANG, "EN") 
//	            .set(SapManagerBuilderOption.CLIENT, "800")
//	            .set(SapManagerBuilderOption.USER, "")
//	            .set(SapManagerBuilderOption.PASSWD, "!")
//	            .build();
//
//	    SapFunction function_parameter = sap.getFunction("ZD_IDNO_CALCU_AGE");
//	    function_parameter.getImportParameterList().setValue("IDNO", "8411112345678");
//
//	    SapFunction function_table = sap.getFunction("ZTEST_RFC_FIORI");
//	    JCoTable iTab = function_table.getImportTableParameter("TBL_MARA");
//	    //List.of ("value1").forEach(e -> {
//	    	iTab.appendRow();
//	    	iTab.setValue("MATNR", "23");
//	    //});
//
//	    SapFunctionResult result = function_parameter.execute();
//	    SapFunctionResult result_table = function_table.execute();
//	    logger.info(result.getExportParameterList().getString("EAST_AGE"));
//	    logger.info(result.getExportParameterList().getInt("WEST_AGE"));
//
//	    List<Map<String, Object>> eTab = result_table.getTable("TBL_MARA");
//	    eTab.forEach(row -> {
//	        row.forEach( (key, value) -> logger.info(key + " : " + value));
//	    });
//	    
//        List<Map<String, Object>> eTab = result_table.getTable("TBL_MARA");
//		for (int i = 0; i < eTab.size() ; i++) {
//			logger.info(eTab.get(i).get("MATNR"));
//			logger.info(eTab.get(i).get("MTART"));
//		}
//	}
}
