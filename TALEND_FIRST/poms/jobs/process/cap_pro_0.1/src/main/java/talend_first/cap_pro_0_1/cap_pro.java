
package talend_first.cap_pro_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.MDM;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: cap_pro Purpose: <br>
 * Description: <br>
 * 
 * @author SONI, KONGA
 * @version 8.0.1.20240524_0800-patch
 * @status
 */
public class cap_pro implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "cap_pro.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(cap_pro.class);

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (test_conn_Login != null) {

				this.setProperty("test_conn_Login", test_conn_Login.toString());

			}

			if (test_conn_Server != null) {

				this.setProperty("test_conn_Server", test_conn_Server.toString());

			}

			if (test_conn_Database != null) {

				this.setProperty("test_conn_Database", test_conn_Database.toString());

			}

			if (test_conn_AdditionalParams != null) {

				this.setProperty("test_conn_AdditionalParams", test_conn_AdditionalParams.toString());

			}

			if (test_conn_Port != null) {

				this.setProperty("test_conn_Port", test_conn_Port.toString());

			}

			if (test_conn_Password != null) {

				this.setProperty("test_conn_Password", test_conn_Password.toString());

			}

			if (test1_conn_Server != null) {

				this.setProperty("test1_conn_Server", test1_conn_Server.toString());

			}

			if (test1_conn_Database != null) {

				this.setProperty("test1_conn_Database", test1_conn_Database.toString());

			}

			if (test1_conn_Password != null) {

				this.setProperty("test1_conn_Password", test1_conn_Password.toString());

			}

			if (test1_conn_AdditionalParams != null) {

				this.setProperty("test1_conn_AdditionalParams", test1_conn_AdditionalParams.toString());

			}

			if (test1_conn_Port != null) {

				this.setProperty("test1_conn_Port", test1_conn_Port.toString());

			}

			if (test1_conn_Login != null) {

				this.setProperty("test1_conn_Login", test1_conn_Login.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String test_conn_Login;

		public String getTest_conn_Login() {
			return this.test_conn_Login;
		}

		public String test_conn_Server;

		public String getTest_conn_Server() {
			return this.test_conn_Server;
		}

		public String test_conn_Database;

		public String getTest_conn_Database() {
			return this.test_conn_Database;
		}

		public String test_conn_AdditionalParams;

		public String getTest_conn_AdditionalParams() {
			return this.test_conn_AdditionalParams;
		}

		public String test_conn_Port;

		public String getTest_conn_Port() {
			return this.test_conn_Port;
		}

		public java.lang.String test_conn_Password;

		public java.lang.String getTest_conn_Password() {
			return this.test_conn_Password;
		}

		public String test1_conn_Server;

		public String getTest1_conn_Server() {
			return this.test1_conn_Server;
		}

		public String test1_conn_Database;

		public String getTest1_conn_Database() {
			return this.test1_conn_Database;
		}

		public java.lang.String test1_conn_Password;

		public java.lang.String getTest1_conn_Password() {
			return this.test1_conn_Password;
		}

		public String test1_conn_AdditionalParams;

		public String getTest1_conn_AdditionalParams() {
			return this.test1_conn_AdditionalParams;
		}

		public String test1_conn_Port;

		public String getTest1_conn_Port() {
			return this.test1_conn_Port;
		}

		public String test1_conn_Login;

		public String getTest1_conn_Login() {
			return this.test1_conn_Login;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	protected java.util.Map<String, String> defaultProperties = new java.util.HashMap<String, String>();
	protected java.util.Map<String, String> additionalProperties = new java.util.HashMap<String, String>();

	public java.util.Map<String, String> getDefaultProperties() {
		return this.defaultProperties;
	}

	public java.util.Map<String, String> getAdditionalProperties() {
		return this.additionalProperties;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "cap_pro";
	private final String projectName = "TALEND_FIRST";
	public Integer errorCode = null;
	private String currentComponent = "";
	public static boolean isStandaloneMS = Boolean.valueOf("false");

	private String cLabel = null;

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName,
			"_CvI1oLGPEe-BqoueWhddPA", "0.1");
	private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

	private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;

		private String currentComponent = null;
		private String cLabel = null;

		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		private TalendException(Exception e, String errorComponent, String errorComponentLabel,
				final java.util.Map<String, Object> globalMap) {
			this(e, errorComponent, globalMap);
			this.cLabel = errorComponentLabel;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					cap_pro.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(cap_pro.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						if (enableLogStash) {
							talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
							talendJobLogProcess(globalMap);
						}
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBConnection_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBConnection_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBConnection_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBConnection_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBConnection_1");
		org.slf4j.MDC.put("_subJobPid", "8r2OPZ_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tDBConnection_1 begin ] start
				 */

				ok_Hash.put("tDBConnection_1", false);
				start_Hash.put("tDBConnection_1", System.currentTimeMillis());

				currentComponent = "tDBConnection_1";

				cLabel = "test_conn";

				int tos_count_tDBConnection_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBConnection_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBConnection_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBConnection_1 = new StringBuilder();
							log4jParamters_tDBConnection_1.append("Parameters:");
							log4jParamters_tDBConnection_1.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("HOST" + " = " + "context.test_conn_Server");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("PORT" + " = " + "context.test_conn_Port");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("DBNAME" + " = " + "context.test_conn_Database");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1
									.append("PROPERTIES" + " = " + "context.test_conn_AdditionalParams");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("USER" + " = " + "context.test_conn_Login");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.test_conn_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("USE_SHARED_CONNECTION" + " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("AUTO_COMMIT" + " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlConnection");
							log4jParamters_tDBConnection_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBConnection_1 - " + (log4jParamters_tDBConnection_1));
						}
					}
					new BytesLimit65535_tDBConnection_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBConnection_1", "test_conn", "tMysqlConnection");
					talendJobLogProcess(globalMap);
				}

				String properties_tDBConnection_1 = context.test_conn_AdditionalParams;
				if (properties_tDBConnection_1 == null || properties_tDBConnection_1.trim().length() == 0) {
					properties_tDBConnection_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBConnection_1.contains("rewriteBatchedStatements=")) {
						properties_tDBConnection_1 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBConnection_1.contains("allowLoadLocalInfile=")) {
						properties_tDBConnection_1 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBConnection_1 = "jdbc:mysql://" + context.test_conn_Server + ":" + context.test_conn_Port
						+ "/" + context.test_conn_Database + "?" + properties_tDBConnection_1;
				String dbUser_tDBConnection_1 = context.test_conn_Login;

				final String decryptedPassword_tDBConnection_1 = context.test_conn_Password;
				String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;

				java.sql.Connection conn_tDBConnection_1 = null;

				String driverClass_tDBConnection_1 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBConnection_1 = java.lang.Class.forName(driverClass_tDBConnection_1);
				globalMap.put("driverClass_tDBConnection_1", driverClass_tDBConnection_1);

				log.debug("tDBConnection_1 - Driver ClassName: " + driverClass_tDBConnection_1 + ".");

				log.debug("tDBConnection_1 - Connection attempt to '" + url_tDBConnection_1 + "' with the username '"
						+ dbUser_tDBConnection_1 + "'.");

				conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1, dbUser_tDBConnection_1,
						dbPwd_tDBConnection_1);
				log.debug("tDBConnection_1 - Connection to '" + url_tDBConnection_1 + "' has succeeded.");

				globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
				if (null != conn_tDBConnection_1) {

					log.debug("tDBConnection_1 - Connection is set auto commit to 'false'.");
					conn_tDBConnection_1.setAutoCommit(false);
				}

				globalMap.put("db_tDBConnection_1", context.test_conn_Database);

				/**
				 * [tDBConnection_1 begin ] stop
				 */

				/**
				 * [tDBConnection_1 main ] start
				 */

				currentComponent = "tDBConnection_1";

				cLabel = "test_conn";

				tos_count_tDBConnection_1++;

				/**
				 * [tDBConnection_1 main ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_begin ] start
				 */

				currentComponent = "tDBConnection_1";

				cLabel = "test_conn";

				/**
				 * [tDBConnection_1 process_data_begin ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_end ] start
				 */

				currentComponent = "tDBConnection_1";

				cLabel = "test_conn";

				/**
				 * [tDBConnection_1 process_data_end ] stop
				 */

				/**
				 * [tDBConnection_1 end ] start
				 */

				currentComponent = "tDBConnection_1";

				cLabel = "test_conn";

				if (log.isDebugEnabled())
					log.debug("tDBConnection_1 - " + ("Done."));

				ok_Hash.put("tDBConnection_1", true);
				end_Hash.put("tDBConnection_1", System.currentTimeMillis());

				/**
				 * [tDBConnection_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBConnection_1 finally ] start
				 */

				currentComponent = "tDBConnection_1";

				cLabel = "test_conn";

				/**
				 * [tDBConnection_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}

	public void tDBConnection_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBConnection_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBConnection_2");
		org.slf4j.MDC.put("_subJobPid", "HdFsiT_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tDBConnection_2 begin ] start
				 */

				ok_Hash.put("tDBConnection_2", false);
				start_Hash.put("tDBConnection_2", System.currentTimeMillis());

				currentComponent = "tDBConnection_2";

				cLabel = "test1_conn";

				int tos_count_tDBConnection_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBConnection_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBConnection_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBConnection_2 = new StringBuilder();
							log4jParamters_tDBConnection_2.append("Parameters:");
							log4jParamters_tDBConnection_2.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("HOST" + " = " + "context.test1_conn_Server");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("PORT" + " = " + "context.test1_conn_Port");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("DBNAME" + " = " + "context.test1_conn_Database");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2
									.append("PROPERTIES" + " = " + "context.test1_conn_AdditionalParams");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("USER" + " = " + "context.test1_conn_Login");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.test1_conn_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("USE_SHARED_CONNECTION" + " = " + "false");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("AUTO_COMMIT" + " = " + "false");
							log4jParamters_tDBConnection_2.append(" | ");
							log4jParamters_tDBConnection_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlConnection");
							log4jParamters_tDBConnection_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBConnection_2 - " + (log4jParamters_tDBConnection_2));
						}
					}
					new BytesLimit65535_tDBConnection_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBConnection_2", "test1_conn", "tMysqlConnection");
					talendJobLogProcess(globalMap);
				}

				String properties_tDBConnection_2 = context.test1_conn_AdditionalParams;
				if (properties_tDBConnection_2 == null || properties_tDBConnection_2.trim().length() == 0) {
					properties_tDBConnection_2 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBConnection_2.contains("rewriteBatchedStatements=")) {
						properties_tDBConnection_2 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBConnection_2.contains("allowLoadLocalInfile=")) {
						properties_tDBConnection_2 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBConnection_2 = "jdbc:mysql://" + context.test1_conn_Server + ":" + context.test1_conn_Port
						+ "/" + context.test1_conn_Database + "?" + properties_tDBConnection_2;
				String dbUser_tDBConnection_2 = context.test1_conn_Login;

				final String decryptedPassword_tDBConnection_2 = context.test1_conn_Password;
				String dbPwd_tDBConnection_2 = decryptedPassword_tDBConnection_2;

				java.sql.Connection conn_tDBConnection_2 = null;

				String driverClass_tDBConnection_2 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBConnection_2 = java.lang.Class.forName(driverClass_tDBConnection_2);
				globalMap.put("driverClass_tDBConnection_2", driverClass_tDBConnection_2);

				log.debug("tDBConnection_2 - Driver ClassName: " + driverClass_tDBConnection_2 + ".");

				log.debug("tDBConnection_2 - Connection attempt to '" + url_tDBConnection_2 + "' with the username '"
						+ dbUser_tDBConnection_2 + "'.");

				conn_tDBConnection_2 = java.sql.DriverManager.getConnection(url_tDBConnection_2, dbUser_tDBConnection_2,
						dbPwd_tDBConnection_2);
				log.debug("tDBConnection_2 - Connection to '" + url_tDBConnection_2 + "' has succeeded.");

				globalMap.put("conn_tDBConnection_2", conn_tDBConnection_2);
				if (null != conn_tDBConnection_2) {

					log.debug("tDBConnection_2 - Connection is set auto commit to 'false'.");
					conn_tDBConnection_2.setAutoCommit(false);
				}

				globalMap.put("db_tDBConnection_2", context.test1_conn_Database);

				/**
				 * [tDBConnection_2 begin ] stop
				 */

				/**
				 * [tDBConnection_2 main ] start
				 */

				currentComponent = "tDBConnection_2";

				cLabel = "test1_conn";

				tos_count_tDBConnection_2++;

				/**
				 * [tDBConnection_2 main ] stop
				 */

				/**
				 * [tDBConnection_2 process_data_begin ] start
				 */

				currentComponent = "tDBConnection_2";

				cLabel = "test1_conn";

				/**
				 * [tDBConnection_2 process_data_begin ] stop
				 */

				/**
				 * [tDBConnection_2 process_data_end ] start
				 */

				currentComponent = "tDBConnection_2";

				cLabel = "test1_conn";

				/**
				 * [tDBConnection_2 process_data_end ] stop
				 */

				/**
				 * [tDBConnection_2 end ] start
				 */

				currentComponent = "tDBConnection_2";

				cLabel = "test1_conn";

				if (log.isDebugEnabled())
					log.debug("tDBConnection_2 - " + ("Done."));

				ok_Hash.put("tDBConnection_2", true);
				end_Hash.put("tDBConnection_2", System.currentTimeMillis());

				/**
				 * [tDBConnection_2 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBConnection_2 finally ] start
				 */

				currentComponent = "tDBConnection_2";

				cLabel = "test1_conn";

				/**
				 * [tDBConnection_2 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBConnection_2_SUBPROCESS_STATE", 1);
	}

	public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_TALEND_FIRST_cap_pro = new byte[0];
		static byte[] commonByteArray_TALEND_FIRST_cap_pro = new byte[0];

		public int emp_id;

		public int getEmp_id() {
			return this.emp_id;
		}

		public Boolean emp_idIsNullable() {
			return false;
		}

		public Boolean emp_idIsKey() {
			return false;
		}

		public Integer emp_idLength() {
			return 10;
		}

		public Integer emp_idPrecision() {
			return 0;
		}

		public String emp_idDefault() {

			return "";

		}

		public String emp_idComment() {

			return "";

		}

		public String emp_idPattern() {

			return "";

		}

		public String emp_idOriginalDbColumnName() {

			return "emp_id";

		}

		public String emp_name;

		public String getEmp_name() {
			return this.emp_name;
		}

		public Boolean emp_nameIsNullable() {
			return true;
		}

		public Boolean emp_nameIsKey() {
			return false;
		}

		public Integer emp_nameLength() {
			return 50;
		}

		public Integer emp_namePrecision() {
			return 0;
		}

		public String emp_nameDefault() {

			return null;

		}

		public String emp_nameComment() {

			return "";

		}

		public String emp_namePattern() {

			return "";

		}

		public String emp_nameOriginalDbColumnName() {

			return "emp_name";

		}

		public BigDecimal salary;

		public BigDecimal getSalary() {
			return this.salary;
		}

		public Boolean salaryIsNullable() {
			return true;
		}

		public Boolean salaryIsKey() {
			return false;
		}

		public Integer salaryLength() {
			return 10;
		}

		public Integer salaryPrecision() {
			return 2;
		}

		public String salaryDefault() {

			return "";

		}

		public String salaryComment() {

			return "";

		}

		public String salaryPattern() {

			return "";

		}

		public String salaryOriginalDbColumnName() {

			return "salary";

		}

		public String department_name;

		public String getDepartment_name() {
			return this.department_name;
		}

		public Boolean department_nameIsNullable() {
			return true;
		}

		public Boolean department_nameIsKey() {
			return false;
		}

		public Integer department_nameLength() {
			return 50;
		}

		public Integer department_namePrecision() {
			return 0;
		}

		public String department_nameDefault() {

			return null;

		}

		public String department_nameComment() {

			return "";

		}

		public String department_namePattern() {

			return "";

		}

		public String department_nameOriginalDbColumnName() {

			return "department_name";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALEND_FIRST_cap_pro.length) {
					if (length < 1024 && commonByteArray_TALEND_FIRST_cap_pro.length == 0) {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[1024];
					} else {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALEND_FIRST_cap_pro, 0, length);
				strReturn = new String(commonByteArray_TALEND_FIRST_cap_pro, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALEND_FIRST_cap_pro.length) {
					if (length < 1024 && commonByteArray_TALEND_FIRST_cap_pro.length == 0) {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[1024];
					} else {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALEND_FIRST_cap_pro, 0, length);
				strReturn = new String(commonByteArray_TALEND_FIRST_cap_pro, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TALEND_FIRST_cap_pro) {

				try {

					int length = 0;

					this.emp_id = dis.readInt();

					this.emp_name = readString(dis);

					this.salary = (BigDecimal) dis.readObject();

					this.department_name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALEND_FIRST_cap_pro) {

				try {

					int length = 0;

					this.emp_id = dis.readInt();

					this.emp_name = readString(dis);

					this.salary = (BigDecimal) dis.readObject();

					this.department_name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.emp_id);

				// String

				writeString(this.emp_name, dos);

				// BigDecimal

				dos.writeObject(this.salary);

				// String

				writeString(this.department_name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.emp_id);

				// String

				writeString(this.emp_name, dos);

				// BigDecimal

				dos.clearInstanceCache();
				dos.writeObject(this.salary);

				// String

				writeString(this.department_name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("emp_id=" + String.valueOf(emp_id));
			sb.append(",emp_name=" + emp_name);
			sb.append(",salary=" + String.valueOf(salary));
			sb.append(",department_name=" + department_name);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(emp_id);

			sb.append("|");

			if (emp_name == null) {
				sb.append("<null>");
			} else {
				sb.append(emp_name);
			}

			sb.append("|");

			if (salary == null) {
				sb.append("<null>");
			} else {
				sb.append(salary);
			}

			sb.append("|");

			if (department_name == null) {
				sb.append("<null>");
			} else {
				sb.append(department_name);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_TALEND_FIRST_cap_pro = new byte[0];
		static byte[] commonByteArray_TALEND_FIRST_cap_pro = new byte[0];

		public int emp_id;

		public int getEmp_id() {
			return this.emp_id;
		}

		public Boolean emp_idIsNullable() {
			return false;
		}

		public Boolean emp_idIsKey() {
			return false;
		}

		public Integer emp_idLength() {
			return 10;
		}

		public Integer emp_idPrecision() {
			return 0;
		}

		public String emp_idDefault() {

			return "";

		}

		public String emp_idComment() {

			return "";

		}

		public String emp_idPattern() {

			return "";

		}

		public String emp_idOriginalDbColumnName() {

			return "emp_id";

		}

		public String emp_name;

		public String getEmp_name() {
			return this.emp_name;
		}

		public Boolean emp_nameIsNullable() {
			return true;
		}

		public Boolean emp_nameIsKey() {
			return false;
		}

		public Integer emp_nameLength() {
			return 50;
		}

		public Integer emp_namePrecision() {
			return 0;
		}

		public String emp_nameDefault() {

			return null;

		}

		public String emp_nameComment() {

			return "";

		}

		public String emp_namePattern() {

			return "";

		}

		public String emp_nameOriginalDbColumnName() {

			return "emp_name";

		}

		public Integer age;

		public Integer getAge() {
			return this.age;
		}

		public Boolean ageIsNullable() {
			return true;
		}

		public Boolean ageIsKey() {
			return false;
		}

		public Integer ageLength() {
			return 10;
		}

		public Integer agePrecision() {
			return 0;
		}

		public String ageDefault() {

			return "";

		}

		public String ageComment() {

			return "";

		}

		public String agePattern() {

			return "";

		}

		public String ageOriginalDbColumnName() {

			return "age";

		}

		public Integer department_id;

		public Integer getDepartment_id() {
			return this.department_id;
		}

		public Boolean department_idIsNullable() {
			return true;
		}

		public Boolean department_idIsKey() {
			return false;
		}

		public Integer department_idLength() {
			return 10;
		}

		public Integer department_idPrecision() {
			return 0;
		}

		public String department_idDefault() {

			return "";

		}

		public String department_idComment() {

			return "";

		}

		public String department_idPattern() {

			return "";

		}

		public String department_idOriginalDbColumnName() {

			return "department_id";

		}

		public BigDecimal salary;

		public BigDecimal getSalary() {
			return this.salary;
		}

		public Boolean salaryIsNullable() {
			return true;
		}

		public Boolean salaryIsKey() {
			return false;
		}

		public Integer salaryLength() {
			return 10;
		}

		public Integer salaryPrecision() {
			return 2;
		}

		public String salaryDefault() {

			return "";

		}

		public String salaryComment() {

			return "";

		}

		public String salaryPattern() {

			return "";

		}

		public String salaryOriginalDbColumnName() {

			return "salary";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALEND_FIRST_cap_pro.length) {
					if (length < 1024 && commonByteArray_TALEND_FIRST_cap_pro.length == 0) {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[1024];
					} else {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALEND_FIRST_cap_pro, 0, length);
				strReturn = new String(commonByteArray_TALEND_FIRST_cap_pro, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALEND_FIRST_cap_pro.length) {
					if (length < 1024 && commonByteArray_TALEND_FIRST_cap_pro.length == 0) {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[1024];
					} else {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALEND_FIRST_cap_pro, 0, length);
				strReturn = new String(commonByteArray_TALEND_FIRST_cap_pro, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TALEND_FIRST_cap_pro) {

				try {

					int length = 0;

					this.emp_id = dis.readInt();

					this.emp_name = readString(dis);

					this.age = readInteger(dis);

					this.department_id = readInteger(dis);

					this.salary = (BigDecimal) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALEND_FIRST_cap_pro) {

				try {

					int length = 0;

					this.emp_id = dis.readInt();

					this.emp_name = readString(dis);

					this.age = readInteger(dis);

					this.department_id = readInteger(dis);

					this.salary = (BigDecimal) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.emp_id);

				// String

				writeString(this.emp_name, dos);

				// Integer

				writeInteger(this.age, dos);

				// Integer

				writeInteger(this.department_id, dos);

				// BigDecimal

				dos.writeObject(this.salary);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.emp_id);

				// String

				writeString(this.emp_name, dos);

				// Integer

				writeInteger(this.age, dos);

				// Integer

				writeInteger(this.department_id, dos);

				// BigDecimal

				dos.clearInstanceCache();
				dos.writeObject(this.salary);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("emp_id=" + String.valueOf(emp_id));
			sb.append(",emp_name=" + emp_name);
			sb.append(",age=" + String.valueOf(age));
			sb.append(",department_id=" + String.valueOf(department_id));
			sb.append(",salary=" + String.valueOf(salary));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(emp_id);

			sb.append("|");

			if (emp_name == null) {
				sb.append("<null>");
			} else {
				sb.append(emp_name);
			}

			sb.append("|");

			if (age == null) {
				sb.append("<null>");
			} else {
				sb.append(age);
			}

			sb.append("|");

			if (department_id == null) {
				sb.append("<null>");
			} else {
				sb.append(department_id);
			}

			sb.append("|");

			if (salary == null) {
				sb.append("<null>");
			} else {
				sb.append(salary);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tDBInput_2Struct implements routines.system.IPersistableRow<after_tDBInput_2Struct> {
		final static byte[] commonByteArrayLock_TALEND_FIRST_cap_pro = new byte[0];
		static byte[] commonByteArray_TALEND_FIRST_cap_pro = new byte[0];

		public int emp_id;

		public int getEmp_id() {
			return this.emp_id;
		}

		public Boolean emp_idIsNullable() {
			return false;
		}

		public Boolean emp_idIsKey() {
			return false;
		}

		public Integer emp_idLength() {
			return 10;
		}

		public Integer emp_idPrecision() {
			return 0;
		}

		public String emp_idDefault() {

			return "";

		}

		public String emp_idComment() {

			return "";

		}

		public String emp_idPattern() {

			return "";

		}

		public String emp_idOriginalDbColumnName() {

			return "emp_id";

		}

		public String emp_name;

		public String getEmp_name() {
			return this.emp_name;
		}

		public Boolean emp_nameIsNullable() {
			return true;
		}

		public Boolean emp_nameIsKey() {
			return false;
		}

		public Integer emp_nameLength() {
			return 50;
		}

		public Integer emp_namePrecision() {
			return 0;
		}

		public String emp_nameDefault() {

			return null;

		}

		public String emp_nameComment() {

			return "";

		}

		public String emp_namePattern() {

			return "";

		}

		public String emp_nameOriginalDbColumnName() {

			return "emp_name";

		}

		public Integer age;

		public Integer getAge() {
			return this.age;
		}

		public Boolean ageIsNullable() {
			return true;
		}

		public Boolean ageIsKey() {
			return false;
		}

		public Integer ageLength() {
			return 10;
		}

		public Integer agePrecision() {
			return 0;
		}

		public String ageDefault() {

			return "";

		}

		public String ageComment() {

			return "";

		}

		public String agePattern() {

			return "";

		}

		public String ageOriginalDbColumnName() {

			return "age";

		}

		public Integer department_id;

		public Integer getDepartment_id() {
			return this.department_id;
		}

		public Boolean department_idIsNullable() {
			return true;
		}

		public Boolean department_idIsKey() {
			return false;
		}

		public Integer department_idLength() {
			return 10;
		}

		public Integer department_idPrecision() {
			return 0;
		}

		public String department_idDefault() {

			return "";

		}

		public String department_idComment() {

			return "";

		}

		public String department_idPattern() {

			return "";

		}

		public String department_idOriginalDbColumnName() {

			return "department_id";

		}

		public BigDecimal salary;

		public BigDecimal getSalary() {
			return this.salary;
		}

		public Boolean salaryIsNullable() {
			return true;
		}

		public Boolean salaryIsKey() {
			return false;
		}

		public Integer salaryLength() {
			return 10;
		}

		public Integer salaryPrecision() {
			return 2;
		}

		public String salaryDefault() {

			return "";

		}

		public String salaryComment() {

			return "";

		}

		public String salaryPattern() {

			return "";

		}

		public String salaryOriginalDbColumnName() {

			return "salary";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALEND_FIRST_cap_pro.length) {
					if (length < 1024 && commonByteArray_TALEND_FIRST_cap_pro.length == 0) {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[1024];
					} else {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALEND_FIRST_cap_pro, 0, length);
				strReturn = new String(commonByteArray_TALEND_FIRST_cap_pro, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALEND_FIRST_cap_pro.length) {
					if (length < 1024 && commonByteArray_TALEND_FIRST_cap_pro.length == 0) {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[1024];
					} else {
						commonByteArray_TALEND_FIRST_cap_pro = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALEND_FIRST_cap_pro, 0, length);
				strReturn = new String(commonByteArray_TALEND_FIRST_cap_pro, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TALEND_FIRST_cap_pro) {

				try {

					int length = 0;

					this.emp_id = dis.readInt();

					this.emp_name = readString(dis);

					this.age = readInteger(dis);

					this.department_id = readInteger(dis);

					this.salary = (BigDecimal) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALEND_FIRST_cap_pro) {

				try {

					int length = 0;

					this.emp_id = dis.readInt();

					this.emp_name = readString(dis);

					this.age = readInteger(dis);

					this.department_id = readInteger(dis);

					this.salary = (BigDecimal) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.emp_id);

				// String

				writeString(this.emp_name, dos);

				// Integer

				writeInteger(this.age, dos);

				// Integer

				writeInteger(this.department_id, dos);

				// BigDecimal

				dos.writeObject(this.salary);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.emp_id);

				// String

				writeString(this.emp_name, dos);

				// Integer

				writeInteger(this.age, dos);

				// Integer

				writeInteger(this.department_id, dos);

				// BigDecimal

				dos.clearInstanceCache();
				dos.writeObject(this.salary);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("emp_id=" + String.valueOf(emp_id));
			sb.append(",emp_name=" + emp_name);
			sb.append(",age=" + String.valueOf(age));
			sb.append(",department_id=" + String.valueOf(department_id));
			sb.append(",salary=" + String.valueOf(salary));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(emp_id);

			sb.append("|");

			if (emp_name == null) {
				sb.append("<null>");
			} else {
				sb.append(emp_name);
			}

			sb.append("|");

			if (age == null) {
				sb.append("<null>");
			} else {
				sb.append(age);
			}

			sb.append("|");

			if (department_id == null) {
				sb.append("<null>");
			} else {
				sb.append(department_id);
			}

			sb.append("|");

			if (salary == null) {
				sb.append("<null>");
			} else {
				sb.append(salary);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_2");
		org.slf4j.MDC.put("_subJobPid", "BieM95_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_4Process(globalMap);

				row1Struct row1 = new row1Struct();
				out1Struct out1 = new out1Struct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "out1");

				int tos_count_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
							log4jParamters_tDBOutput_1.append("Parameters:");
							log4jParamters_tDBOutput_1.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("HOST" + " = " + "context.test_conn_Server");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PORT" + " = " + "context.test_conn_Port");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DBNAME" + " = " + "context.test_conn_Database");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USER" + " = " + "context.test_conn_Login");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.test_conn_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"output_tab\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "DROP_IF_EXISTS_AND_CREATE");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "INSERT");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1
									.append("PROPERTIES" + " = " + "context.test_conn_AdditionalParams");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("EXTENDINSERT" + " = " + "true");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("NB_ROWS_PER_INSERT" + " = " + "100");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("COMMIT_EVERY" + " = " + "10000");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_HINT_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
							log4jParamters_tDBOutput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + (log4jParamters_tDBOutput_1));
						}
					}
					new BytesLimit65535_tDBOutput_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBOutput_1", "tDBOutput_1", "tMysqlOutput");
					talendJobLogProcess(globalMap);
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				String tableName_tDBOutput_1 = "output_tab";
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				long date_tDBOutput_1;

				java.sql.Connection conn_tDBOutput_1 = null;

				String properties_tDBOutput_1 = context.test_conn_AdditionalParams;
				if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
					properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_1 = "jdbc:mysql://" + context.test_conn_Server + ":" + context.test_conn_Port + "/"
						+ context.test_conn_Database + "?" + properties_tDBOutput_1;

				String driverClass_tDBOutput_1 = "com.mysql.cj.jdbc.Driver";

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Driver ClassName: ") + (driverClass_tDBOutput_1) + ("."));
				String dbUser_tDBOutput_1 = context.test_conn_Login;

				final String decryptedPassword_tDBOutput_1 = context.test_conn_Password;

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				java.lang.Class.forName(driverClass_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection attempts to '") + (url_tDBOutput_1)
							+ ("' with the username '") + (dbUser_tDBOutput_1) + ("'."));
				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to '") + (url_tDBOutput_1) + ("' has succeeded."));

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);

				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection is set auto commit to '")
							+ (conn_tDBOutput_1.getAutoCommit()) + ("'."));

				int count_tDBOutput_1 = 0;

				java.sql.DatabaseMetaData dbMetaData_tDBOutput_1 = conn_tDBOutput_1.getMetaData();
				java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables(context.test_conn_Database,
						null, null, new String[] { "TABLE" });
				boolean whetherExist_tDBOutput_1 = false;
				while (rsTable_tDBOutput_1.next()) {
					String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
					if (table_tDBOutput_1.equalsIgnoreCase("output_tab")) {
						whetherExist_tDBOutput_1 = true;
						break;
					}
				}
				if (whetherExist_tDBOutput_1) {
					try (java.sql.Statement stmtDrop_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
						if (log.isDebugEnabled())
							log.debug(
									"tDBOutput_1 - " + ("Dropping") + (" table '") + (tableName_tDBOutput_1) + ("'."));
						stmtDrop_tDBOutput_1.execute("DROP TABLE `" + tableName_tDBOutput_1 + "`");
						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Drop") + (" table '") + (tableName_tDBOutput_1)
									+ ("' has succeeded."));
					}
				}
				try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Creating") + (" table '") + (tableName_tDBOutput_1) + ("'."));
					stmtCreate_tDBOutput_1.execute("CREATE TABLE `" + tableName_tDBOutput_1
							+ "`(`emp_id` INT(10)   not null ,`emp_name` VARCHAR(50)  ,`salary` DECIMAL(10,2)  ,`department_name` VARCHAR(50)  )");
					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Create") + (" table '") + (tableName_tDBOutput_1)
								+ ("' has succeeded."));
				}

				String insert_tDBOutput_1 = "INSERT INTO `" + "output_tab"
						+ "` (`emp_id`,`emp_name`,`salary`,`department_name`) VALUES (?,?,?,?)";

				int batchSize_tDBOutput_1 = 100;
				int batchSizeCounter_tDBOutput_1 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

				int tos_count_tMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_1 = new StringBuilder();
							log4jParamters_tMap_1.append("Parameters:");
							log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_1 - " + (log4jParamters_tMap_1));
						}
					}
					new BytesLimit65535_tMap_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
					talendJobLogProcess(globalMap);
				}

// ###############################
// # Lookup's keys initialization
				int count_row1_tMap_1 = 0;

				int count_row2_tMap_1 = 0;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) globalMap
						.get("tHash_Lookup_row2"));

				row2Struct row2HashKey = new row2Struct();
				row2Struct row2Default = new row2Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_out1_tMap_1 = 0;

				out1Struct out1_tmp = new out1Struct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				int tos_count_tDBInput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
							log4jParamters_tDBInput_2.append("Parameters:");
							log4jParamters_tDBInput_2.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("HOST" + " = " + "context.test_conn_Server");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PORT" + " = " + "context.test_conn_Port");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("DBNAME" + " = " + "context.test_conn_Database");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("USER" + " = " + "context.test_conn_Login");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.test_conn_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TABLE" + " = " + "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERY" + " = " + "\"select * from data_employees\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2
									.append("PROPERTIES" + " = " + "context.test_conn_AdditionalParams");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("emp_id") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("emp_name") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("age")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("department_id") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("salary") + "}]");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_2 - " + (log4jParamters_tDBInput_2));
						}
					}
					new BytesLimit65535_tDBInput_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_2", "tDBInput_2", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_2 = java.util.Calendar.getInstance();
				calendar_tDBInput_2.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_2 = calendar_tDBInput_2.getTime();
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = context.test_conn_Login;

				final String decryptedPassword_tDBInput_2 = context.test_conn_Password;

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String properties_tDBInput_2 = context.test_conn_AdditionalParams;
				if (properties_tDBInput_2 == null || properties_tDBInput_2.trim().length() == 0) {
					properties_tDBInput_2 = "";
				}
				String url_tDBInput_2 = "jdbc:mysql://" + context.test_conn_Server + ":" + context.test_conn_Port + "/"
						+ context.test_conn_Database + "?" + properties_tDBInput_2;

				log.debug("tDBInput_2 - Driver ClassName: " + driverClass_tDBInput_2 + ".");

				log.debug("tDBInput_2 - Connection attempt to '" + url_tDBInput_2 + "' with the username '"
						+ dbUser_tDBInput_2 + "'.");

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);
				log.debug("tDBInput_2 - Connection to '" + url_tDBInput_2 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "select * from data_employees";

				log.debug("tDBInput_2 - Executing the query: '" + dbquery_tDBInput_2 + "'.");

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);

				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					log.debug("tDBInput_2 - Retrieving records from the database.");

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row1.emp_id = 0;
						} else {

							row1.emp_id = rs_tDBInput_2.getInt(1);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row1.emp_name = null;
						} else {

							row1.emp_name = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							row1.age = null;
						} else {

							row1.age = rs_tDBInput_2.getInt(3);
							if (rs_tDBInput_2.wasNull()) {
								row1.age = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 4) {
							row1.department_id = null;
						} else {

							row1.department_id = rs_tDBInput_2.getInt(4);
							if (rs_tDBInput_2.wasNull()) {
								row1.department_id = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 5) {
							row1.salary = null;
						} else {

							row1.salary = rs_tDBInput_2.getBigDecimal(5);
							if (rs_tDBInput_2.wasNull()) {
								row1.salary = null;
							}
						}

						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row1", "tDBInput_2", "tDBInput_2", "tMysqlInput", "tMap_1", "tMap_1", "tMap"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						row2Struct row2 = null;

						// ###############################
						// # Input tables (lookups)

						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						///////////////////////////////////////////////
						// Starting Lookup Table "row2"
						///////////////////////////////////////////////

						boolean forceLooprow2 = false;

						row2Struct row2ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							Object exprKeyValue_row2__department_id = row1.department_id;
							if (exprKeyValue_row2__department_id == null) {
								hasCasePrimitiveKeyWithNull_tMap_1 = true;
							} else {
								row2HashKey.department_id = (int) (Integer) exprKeyValue_row2__department_id;
							}

							row2HashKey.hashCodeDirty = true;

							if (!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091

								tHash_Lookup_row2.lookup(row2HashKey);

							} // G_TM_M_091

						} // G_TM_M_020

						if (tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2'
							// and it contains more one result from keys : row2.department_id = '" +
							// row2HashKey.department_id + "'");
						} // G 071

						row2Struct fromLookup_row2 = null;
						row2 = row2Default;

						if (tHash_Lookup_row2 != null && tHash_Lookup_row2.hasNext()) { // G 099

							fromLookup_row2 = tHash_Lookup_row2.next();

						} // G 099

						if (fromLookup_row2 != null) {
							row2 = fromLookup_row2;
						}

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							out1 = null;

// # Output table : 'out1'
							count_out1_tMap_1++;

							out1_tmp.emp_id = row1.emp_id;
							out1_tmp.emp_name = row1.emp_name;
							out1_tmp.salary = row1.salary;
							out1_tmp.department_name = row2.department_name;
							out1 = out1_tmp;
							log.debug("tMap_1 - Outputting the record " + count_out1_tMap_1
									+ " of the output table 'out1'.");

// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
// Start of branch "out1"
						if (out1 != null) {

							/**
							 * [tDBOutput_1 main ] start
							 */

							currentComponent = "tDBOutput_1";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "out1", "tMap_1", "tMap_1", "tMap", "tDBOutput_1", "tDBOutput_1", "tMysqlOutput"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("out1 - " + (out1 == null ? "" : out1.toLogString()));
							}

							whetherReject_tDBOutput_1 = false;
							pstmt_tDBOutput_1.setInt(1, out1.emp_id);

							if (out1.emp_name == null) {
								pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(2, out1.emp_name);
							}

							pstmt_tDBOutput_1.setBigDecimal(3, out1.salary);

							if (out1.department_name == null) {
								pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(4, out1.department_name);
							}

							pstmt_tDBOutput_1.addBatch();
							nb_line_tDBOutput_1++;

							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + ("Adding the record ") + (nb_line_tDBOutput_1)
										+ (" to the ") + ("INSERT") + (" batch."));
							batchSizeCounter_tDBOutput_1++;
							if (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1) {
								try {
									int countSum_tDBOutput_1 = 0;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
									for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
										countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED
												? 0
												: 1);
									}
									rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
												+ (" batch execution has succeeded."));
									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
								} catch (java.sql.BatchUpdateException e) {
									globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
									int countSum_tDBOutput_1 = 0;
									for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
										countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
									}
									rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
									System.err.println(e.getMessage());
									log.error("tDBOutput_1 - " + (e.getMessage()));
								}

								batchSizeCounter_tDBOutput_1 = 0;
							}
							commitCounter_tDBOutput_1++;

							if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

								try {
									int countSum_tDBOutput_1 = 0;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
									for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
										countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : 1);
									}
									rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
												+ (" batch execution has succeeded."));
									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
								} catch (java.sql.BatchUpdateException e) {
									globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
									int countSum_tDBOutput_1 = 0;
									for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
										countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
									}
									rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
									System.err.println(e.getMessage());
									log.error("tDBOutput_1 - " + (e.getMessage()));

								}
								if (rowsToCommitCount_tDBOutput_1 != 0) {
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
												+ (rowsToCommitCount_tDBOutput_1) + (" record(s)."));
								}
								conn_tDBOutput_1.commit();
								if (rowsToCommitCount_tDBOutput_1 != 0) {
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
									rowsToCommitCount_tDBOutput_1 = 0;
								}
								commitCounter_tDBOutput_1 = 0;
							}

							tos_count_tDBOutput_1++;

							/**
							 * [tDBOutput_1 main ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_1";

							/**
							 * [tDBOutput_1 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_end ] start
							 */

							currentComponent = "tDBOutput_1";

							/**
							 * [tDBOutput_1 process_data_end ] stop
							 */

						} // End of branch "out1"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						log.debug("tDBInput_2 - Closing the connection to the database.");

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_2 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);
				log.debug("tDBInput_2 - Retrieved records count: " + nb_line_tDBInput_2 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Done."));

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row2 != null) {
					tHash_Lookup_row2.endGet();
				}
				globalMap.remove("tHash_Lookup_row2");

// ###############################      
				log.debug("tMap_1 - Written records count in the table 'out1': " + count_out1_tMap_1 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tDBInput_2", "tDBInput_2", "tMysqlInput", "tMap_1", "tMap_1", "tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Done."));

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (batchSizeCounter_tDBOutput_1 != 0) {
						int countSum_tDBOutput_1 = 0;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("The ") + ("INSERT") + (" batch execution has succeeded."));

						insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					}
				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					log.error("tDBOutput_1 - " + (e.getMessage()));
					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_1 = 0;

				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");

				}

				resourceMap.put("statementClosed_tDBOutput_1", true);

				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
								+ (rowsToCommitCount_tDBOutput_1) + (" record(s)."));
				}
				conn_tDBOutput_1.commit();
				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
				conn_tDBOutput_1.close();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Has ") + ("inserted") + (" ") + (nb_line_inserted_tDBOutput_1)
							+ (" record(s)."));

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "out1", 2, 0, "tMap_1",
						"tMap_1", "tMap", "tDBOutput_1", "tDBOutput_1", "tMysqlOutput", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Done."));

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row2");

			try {

				/**
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
								ctn_tDBOutput_1.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								log.error("tDBOutput_1 - " + (errorMessage_tDBOutput_1));
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
		final static byte[] commonByteArrayLock_TALEND_FIRST_cap_pro = new byte[0];
		static byte[] commonByteArray_TALEND_FIRST_cap_pro = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int department_id;

		public int getDepartment_id() {
			return this.department_id;
		}

		public Boolean department_idIsNullable() {
			return false;
		}

		public Boolean department_idIsKey() {
			return false;
		}

		public Integer department_idLength() {
			return 10;
		}

		public Integer department_idPrecision() {
			return 0;
		}

		public String department_idDefault() {

			return "";

		}

		public String department_idComment() {

			return "";

		}

		public String department_idPattern() {

			return "";

		}

		public String department_idOriginalDbColumnName() {

			return "department_id";

		}

		public String department_name;

		public String getDepartment_name() {
			return this.department_name;
		}

		public Boolean department_nameIsNullable() {
			return true;
		}

		public Boolean department_nameIsKey() {
			return false;
		}

		public Integer department_nameLength() {
			return 50;
		}

		public Integer department_namePrecision() {
			return 0;
		}

		public String department_nameDefault() {

			return null;

		}

		public String department_nameComment() {

			return "";

		}

		public String department_namePattern() {

			return "";

		}

		public String department_nameOriginalDbColumnName() {

			return "department_name";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.department_id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row2Struct other = (row2Struct) obj;

			if (this.department_id != other.department_id)
				return false;

			return true;
		}

		public void copyDataTo(row2Struct other) {

			other.department_id = this.department_id;
			other.department_name = this.department_name;

		}

		public void copyKeysDataTo(row2Struct other) {

			other.department_id = this.department_id;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TALEND_FIRST_cap_pro) {

				try {

					int length = 0;

					this.department_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALEND_FIRST_cap_pro) {

				try {

					int length = 0;

					this.department_id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.department_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.department_id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.department_name = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.department_name = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.department_name, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.department_name, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("department_id=" + String.valueOf(department_id));
			sb.append(",department_name=" + department_name);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(department_id);

			sb.append("|");

			if (department_name == null) {
				sb.append("<null>");
			} else {
				sb.append(department_name);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.department_id, other.department_id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tDBInput_4");
		org.slf4j.MDC.put("_subJobPid", "dXOw3o_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row2Struct row2 = new row2Struct();

				/**
				 * [tAdvancedHash_row2 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row2", false);
				start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row2";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row2");

				int tos_count_tAdvancedHash_row2 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAdvancedHash_row2", "tAdvancedHash_row2", "tAdvancedHash");
					talendJobLogProcess(globalMap);
				}

				// connection name:row2
				// source node:tDBInput_4 - inputs:(after_tDBInput_2) outputs:(row2,row2) |
				// target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2) outputs:(out1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row2Struct>getLookup(matchingModeEnum_row2);

				globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);

				/**
				 * [tAdvancedHash_row2 begin ] stop
				 */

				/**
				 * [tDBInput_4 begin ] start
				 */

				ok_Hash.put("tDBInput_4", false);
				start_Hash.put("tDBInput_4", System.currentTimeMillis());

				currentComponent = "tDBInput_4";

				int tos_count_tDBInput_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_4 = new StringBuilder();
							log4jParamters_tDBInput_4.append("Parameters:");
							log4jParamters_tDBInput_4.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("HOST" + " = " + "context.test1_conn_Server");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("PORT" + " = " + "context.test1_conn_Port");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("DBNAME" + " = " + "context.test1_conn_Database");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("USER" + " = " + "context.test1_conn_Login");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4
									.append("PASS" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil
													.encryptPassword(context.test1_conn_Password)).substring(0, 4)
											+ "...");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("TABLE" + " = " + "\"\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("QUERY" + " = " + "\"select * from departments\"");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4
									.append("PROPERTIES" + " = " + "context.test1_conn_AdditionalParams");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("department_id") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("department_name") + "}]");
							log4jParamters_tDBInput_4.append(" | ");
							log4jParamters_tDBInput_4.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_4 - " + (log4jParamters_tDBInput_4));
						}
					}
					new BytesLimit65535_tDBInput_4().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_4", "tDBInput_4", "tMysqlInput");
					talendJobLogProcess(globalMap);
				}

				java.util.Calendar calendar_tDBInput_4 = java.util.Calendar.getInstance();
				calendar_tDBInput_4.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_4 = calendar_tDBInput_4.getTime();
				int nb_line_tDBInput_4 = 0;
				java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = context.test1_conn_Login;

				final String decryptedPassword_tDBInput_4 = context.test1_conn_Password;

				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;

				String properties_tDBInput_4 = context.test1_conn_AdditionalParams;
				if (properties_tDBInput_4 == null || properties_tDBInput_4.trim().length() == 0) {
					properties_tDBInput_4 = "";
				}
				String url_tDBInput_4 = "jdbc:mysql://" + context.test1_conn_Server + ":" + context.test1_conn_Port
						+ "/" + context.test1_conn_Database + "?" + properties_tDBInput_4;

				log.debug("tDBInput_4 - Driver ClassName: " + driverClass_tDBInput_4 + ".");

				log.debug("tDBInput_4 - Connection attempt to '" + url_tDBInput_4 + "' with the username '"
						+ dbUser_tDBInput_4 + "'.");

				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4, dbUser_tDBInput_4,
						dbPwd_tDBInput_4);
				log.debug("tDBInput_4 - Connection to '" + url_tDBInput_4 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

				String dbquery_tDBInput_4 = "select * from departments";

				log.debug("tDBInput_4 - Executing the query: '" + dbquery_tDBInput_4 + "'.");

				globalMap.put("tDBInput_4_QUERY", dbquery_tDBInput_4);

				java.sql.ResultSet rs_tDBInput_4 = null;

				try {
					rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
					java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
					int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

					String tmpContent_tDBInput_4 = null;

					log.debug("tDBInput_4 - Retrieving records from the database.");

					while (rs_tDBInput_4.next()) {
						nb_line_tDBInput_4++;

						if (colQtyInRs_tDBInput_4 < 1) {
							row2.department_id = 0;
						} else {

							row2.department_id = rs_tDBInput_4.getInt(1);
							if (rs_tDBInput_4.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_4 < 2) {
							row2.department_name = null;
						} else {

							row2.department_name = routines.system.JDBCUtil.getString(rs_tDBInput_4, 2, false);
						}

						log.debug("tDBInput_4 - Retrieving the record " + nb_line_tDBInput_4 + ".");

						/**
						 * [tDBInput_4 begin ] stop
						 */

						/**
						 * [tDBInput_4 main ] start
						 */

						currentComponent = "tDBInput_4";

						tos_count_tDBInput_4++;

						/**
						 * [tDBInput_4 main ] stop
						 */

						/**
						 * [tDBInput_4 process_data_begin ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 main ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row2", "tDBInput_4", "tDBInput_4", "tMysqlInput", "tAdvancedHash_row2",
								"tAdvancedHash_row2", "tAdvancedHash"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
						}

						row2Struct row2_HashRow = new row2Struct();

						row2_HashRow.department_id = row2.department_id;

						row2_HashRow.department_name = row2.department_name;

						tHash_Lookup_row2.put(row2_HashRow);

						tos_count_tAdvancedHash_row2++;

						/**
						 * [tAdvancedHash_row2 main ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 process_data_end ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 end ] start
						 */

						currentComponent = "tDBInput_4";

					}
				} finally {
					if (rs_tDBInput_4 != null) {
						rs_tDBInput_4.close();
					}
					if (stmt_tDBInput_4 != null) {
						stmt_tDBInput_4.close();
					}
					if (conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {

						log.debug("tDBInput_4 - Closing the connection to the database.");

						conn_tDBInput_4.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_4 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_4_NB_LINE", nb_line_tDBInput_4);
				log.debug("tDBInput_4 - Retrieved records count: " + nb_line_tDBInput_4 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_4 - " + ("Done."));

				ok_Hash.put("tDBInput_4", true);
				end_Hash.put("tDBInput_4", System.currentTimeMillis());

				/**
				 * [tDBInput_4 end ] stop
				 */

				/**
				 * [tAdvancedHash_row2 end ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				tHash_Lookup_row2.endPut();

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row2", 2, 0,
						"tDBInput_4", "tDBInput_4", "tMysqlInput", "tAdvancedHash_row2", "tAdvancedHash_row2",
						"tAdvancedHash", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tAdvancedHash_row2", true);
				end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_4 finally ] start
				 */

				currentComponent = "tDBInput_4";

				/**
				 * [tDBInput_4 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row2 finally ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				/**
				 * [tAdvancedHash_row2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [talendJobLog begin ] start
				 */

				ok_Hash.put("talendJobLog", false);
				start_Hash.put("talendJobLog", System.currentTimeMillis());

				currentComponent = "talendJobLog";

				int tos_count_talendJobLog = 0;

				for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
					org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder
							.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
							.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid)
							.custom("father_pid", fatherPid).custom("root_pid", rootPid);
					org.talend.logging.audit.Context log_context_talendJobLog = null;

					if (jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.sourceId(jcm.sourceId)
								.sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
								.targetId(jcm.targetId).targetLabel(jcm.targetLabel)
								.targetConnectorType(jcm.targetComponentName).connectionName(jcm.current_connector)
								.rows(jcm.row_count).duration(duration).build();
						auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
						auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).duration(duration)
								.status(jcm.status).build();
						auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
								.connectorType(jcm.component_name).connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label).build();
						auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {// log current component
																							// input line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {// log current component
																								// output/reject line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
						java.lang.Exception e_talendJobLog = jcm.exception;
						if (e_talendJobLog != null) {
							try (java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();
									java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
								e_talendJobLog.printStackTrace(pw_talendJobLog);
								builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,
										java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
							}
						}

						if (jcm.extra_info != null) {
							builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
						}

						log_context_talendJobLog = builder_talendJobLog
								.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
								.connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label)
								.build();

						auditLogger_talendJobLog.exception(log_context_talendJobLog);
					}

				}

				/**
				 * [talendJobLog begin ] stop
				 */

				/**
				 * [talendJobLog main ] start
				 */

				currentComponent = "talendJobLog";

				tos_count_talendJobLog++;

				/**
				 * [talendJobLog main ] stop
				 */

				/**
				 * [talendJobLog process_data_begin ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_begin ] stop
				 */

				/**
				 * [talendJobLog process_data_end ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_end ] stop
				 */

				/**
				 * [talendJobLog end ] start
				 */

				currentComponent = "talendJobLog";

				ok_Hash.put("talendJobLog", true);
				end_Hash.put("talendJobLog", System.currentTimeMillis());

				/**
				 * [talendJobLog end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [talendJobLog finally ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	private final static java.util.Properties jobInfo = new java.util.Properties();
	private final static java.util.Map<String, String> mdcInfo = new java.util.HashMap<>();
	private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();

	public static void main(String[] args) {
		final cap_pro cap_proClass = new cap_pro();

		int exitCode = cap_proClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'cap_pro' - Done.");
		}

		System.exit(exitCode);
	}

	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if (path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
		readJobInfo(new java.io.File(BUILD_PATH));
	}

	private void readJobInfo(java.io.File jobInfoFile) {

		if (jobInfoFile.exists()) {
			try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
				jobInfo.load(is);
			} catch (IOException e) {

				log.debug("Read jobInfo.properties file fail: " + e.getMessage());

			}
		}
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s", projectName,
				jobName, jobInfo.getProperty("gitCommitId"), "8.0.1.20240524_0800-patch"));

	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}

		getjobInfo();
		log.info("TalendJob: 'cap_pro' - Start.");

		java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
		for (Object jobInfoKey : jobInfoKeys) {
			org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
		}
		org.slf4j.MDC.put("_pid", pid);
		org.slf4j.MDC.put("_rootPid", rootPid);
		org.slf4j.MDC.put("_fatherPid", fatherPid);
		org.slf4j.MDC.put("_projectName", projectName);
		org.slf4j.MDC.put("_startTimestamp", java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC)
				.format(java.time.format.DateTimeFormatter.ISO_INSTANT));
		org.slf4j.MDC.put("_jobRepositoryId", "_CvI1oLGPEe-BqoueWhddPA");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2024-12-03T16:44:44.344487400Z");

		java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
		String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
		if (mxNameTable.length == 2) {
			org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
		} else {
			org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
		}

		if (enableLogStash) {
			java.util.Properties properties_talendJobLog = new java.util.Properties();
			properties_talendJobLog.setProperty("root.logger", "audit");
			properties_talendJobLog.setProperty("encoding", "UTF-8");
			properties_talendJobLog.setProperty("application.name", "Talend Studio");
			properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
			properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
			properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
			properties_talendJobLog.setProperty("log.appender", "file");
			properties_talendJobLog.setProperty("appender.file.path", "audit.json");
			properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
			properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
			properties_talendJobLog.setProperty("host", "false");

			System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()),
							System.getProperty(key)));

			org.apache.logging.log4j.core.config.Configurator
					.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);

			auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory
					.createJobAuditLogger(properties_talendJobLog);
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		org.slf4j.MDC.put("_pid", pid);

		if (rootPid == null) {
			rootPid = pid;
		}

		org.slf4j.MDC.put("_rootPid", rootPid);

		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}
		org.slf4j.MDC.put("_fatherPid", fatherPid);

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		try {
			java.util.Dictionary<String, Object> jobProperties = null;
			if (inOSGi) {
				jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

				if (jobProperties != null && jobProperties.get("context") != null) {
					contextStr = (String) jobProperties.get("context");
				}
			}

			// first load default key-value pairs from application.properties
			if (isStandaloneMS) {
				context.putAll(this.getDefaultProperties());
			}
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = cap_pro.class.getClassLoader()
					.getResourceAsStream("talend_first/cap_pro_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = cap_pro.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						if (inOSGi && jobProperties != null) {
							java.util.Enumeration<String> keys = jobProperties.keys();
							while (keys.hasMoreElements()) {
								String propKey = keys.nextElement();
								if (defaultProps.containsKey(propKey)) {
									defaultProps.put(propKey, (String) jobProperties.get(propKey));
								}
							}
						}
						context = new ContextProperties(defaultProps);
					}
					if (isStandaloneMS) {
						// override context key-value pairs if provided using --context=contextName
						defaultProps.load(inContext);
						context.putAll(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}
			// override key-value pairs if provided via --config.location=file1.file2 OR
			// --config.additional-location=file1,file2
			if (isStandaloneMS) {
				context.putAll(this.getAdditionalProperties());
			}

			// override key-value pairs if provide via command line like
			// --key1=value1,--key2=value2
			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("test_conn_Login", "id_String");
					if (context.getStringValue("test_conn_Login") == null) {
						context.test_conn_Login = null;
					} else {
						context.test_conn_Login = (String) context.getProperty("test_conn_Login");
					}
					context.setContextType("test_conn_Server", "id_String");
					if (context.getStringValue("test_conn_Server") == null) {
						context.test_conn_Server = null;
					} else {
						context.test_conn_Server = (String) context.getProperty("test_conn_Server");
					}
					context.setContextType("test_conn_Database", "id_String");
					if (context.getStringValue("test_conn_Database") == null) {
						context.test_conn_Database = null;
					} else {
						context.test_conn_Database = (String) context.getProperty("test_conn_Database");
					}
					context.setContextType("test_conn_AdditionalParams", "id_String");
					if (context.getStringValue("test_conn_AdditionalParams") == null) {
						context.test_conn_AdditionalParams = null;
					} else {
						context.test_conn_AdditionalParams = (String) context.getProperty("test_conn_AdditionalParams");
					}
					context.setContextType("test_conn_Port", "id_String");
					if (context.getStringValue("test_conn_Port") == null) {
						context.test_conn_Port = null;
					} else {
						context.test_conn_Port = (String) context.getProperty("test_conn_Port");
					}
					context.setContextType("test_conn_Password", "id_Password");
					if (context.getStringValue("test_conn_Password") == null) {
						context.test_conn_Password = null;
					} else {
						String pwd_test_conn_Password_value = context.getProperty("test_conn_Password");
						context.test_conn_Password = null;
						if (pwd_test_conn_Password_value != null) {
							if (context_param.containsKey("test_conn_Password")) {// no need to decrypt if it come from
																					// program argument or parent job
																					// runtime
								context.test_conn_Password = pwd_test_conn_Password_value;
							} else if (!pwd_test_conn_Password_value.isEmpty()) {
								try {
									context.test_conn_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_test_conn_Password_value);
									context.put("test_conn_Password", context.test_conn_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("test1_conn_Server", "id_String");
					if (context.getStringValue("test1_conn_Server") == null) {
						context.test1_conn_Server = null;
					} else {
						context.test1_conn_Server = (String) context.getProperty("test1_conn_Server");
					}
					context.setContextType("test1_conn_Database", "id_String");
					if (context.getStringValue("test1_conn_Database") == null) {
						context.test1_conn_Database = null;
					} else {
						context.test1_conn_Database = (String) context.getProperty("test1_conn_Database");
					}
					context.setContextType("test1_conn_Password", "id_Password");
					if (context.getStringValue("test1_conn_Password") == null) {
						context.test1_conn_Password = null;
					} else {
						String pwd_test1_conn_Password_value = context.getProperty("test1_conn_Password");
						context.test1_conn_Password = null;
						if (pwd_test1_conn_Password_value != null) {
							if (context_param.containsKey("test1_conn_Password")) {// no need to decrypt if it come from
																					// program argument or parent job
																					// runtime
								context.test1_conn_Password = pwd_test1_conn_Password_value;
							} else if (!pwd_test1_conn_Password_value.isEmpty()) {
								try {
									context.test1_conn_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_test1_conn_Password_value);
									context.put("test1_conn_Password", context.test1_conn_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("test1_conn_AdditionalParams", "id_String");
					if (context.getStringValue("test1_conn_AdditionalParams") == null) {
						context.test1_conn_AdditionalParams = null;
					} else {
						context.test1_conn_AdditionalParams = (String) context
								.getProperty("test1_conn_AdditionalParams");
					}
					context.setContextType("test1_conn_Port", "id_String");
					if (context.getStringValue("test1_conn_Port") == null) {
						context.test1_conn_Port = null;
					} else {
						context.test1_conn_Port = (String) context.getProperty("test1_conn_Port");
					}
					context.setContextType("test1_conn_Login", "id_String");
					if (context.getStringValue("test1_conn_Login") == null) {
						context.test1_conn_Login = null;
					} else {
						context.test1_conn_Login = (String) context.getProperty("test1_conn_Login");
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("test_conn_Login")) {
				context.test_conn_Login = (String) parentContextMap.get("test_conn_Login");
			}
			if (parentContextMap.containsKey("test_conn_Server")) {
				context.test_conn_Server = (String) parentContextMap.get("test_conn_Server");
			}
			if (parentContextMap.containsKey("test_conn_Database")) {
				context.test_conn_Database = (String) parentContextMap.get("test_conn_Database");
			}
			if (parentContextMap.containsKey("test_conn_AdditionalParams")) {
				context.test_conn_AdditionalParams = (String) parentContextMap.get("test_conn_AdditionalParams");
			}
			if (parentContextMap.containsKey("test_conn_Port")) {
				context.test_conn_Port = (String) parentContextMap.get("test_conn_Port");
			}
			if (parentContextMap.containsKey("test_conn_Password")) {
				context.test_conn_Password = (java.lang.String) parentContextMap.get("test_conn_Password");
			}
			if (parentContextMap.containsKey("test1_conn_Server")) {
				context.test1_conn_Server = (String) parentContextMap.get("test1_conn_Server");
			}
			if (parentContextMap.containsKey("test1_conn_Database")) {
				context.test1_conn_Database = (String) parentContextMap.get("test1_conn_Database");
			}
			if (parentContextMap.containsKey("test1_conn_Password")) {
				context.test1_conn_Password = (java.lang.String) parentContextMap.get("test1_conn_Password");
			}
			if (parentContextMap.containsKey("test1_conn_AdditionalParams")) {
				context.test1_conn_AdditionalParams = (String) parentContextMap.get("test1_conn_AdditionalParams");
			}
			if (parentContextMap.containsKey("test1_conn_Port")) {
				context.test1_conn_Port = (String) parentContextMap.get("test1_conn_Port");
			}
			if (parentContextMap.containsKey("test1_conn_Login")) {
				context.test1_conn_Login = (String) parentContextMap.get("test1_conn_Login");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("test_conn_Password");
		parametersToEncrypt.add("test1_conn_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'cap_pro' - Started.");
		java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		if (enableLogStash) {
			talendJobLog.addJobStartMessage();
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tDBConnection_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBConnection_1) {
			globalMap.put("tDBConnection_1_SUBPROCESS_STATE", -1);

			e_tDBConnection_1.printStackTrace();

		}
		try {
			errorCode = null;
			tDBConnection_2Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBConnection_2) {
			globalMap.put("tDBConnection_2_SUBPROCESS_STATE", -1);

			e_tDBConnection_2.printStackTrace();

		}
		try {
			errorCode = null;
			tDBInput_2Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_2) {
			globalMap.put("tDBInput_2_SUBPROCESS_STATE", -1);

			e_tDBInput_2.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : cap_pro");
		}
		if (enableLogStash) {
			talendJobLog.addJobEndMessage(startTime, end, status);
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");
		resumeUtil.flush();

		org.slf4j.MDC.remove("_subJobName");
		org.slf4j.MDC.remove("_subJobPid");
		org.slf4j.MDC.remove("_systemPid");
		log.info("TalendJob: 'cap_pro' - Finished - status: " + status + " returnCode: " + returnCode);

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {
		closeSqlDbConnections();

	}

	private void closeSqlDbConnections() {
		try {
			Object obj_conn;
			obj_conn = globalMap.remove("conn_tDBConnection_1");
			if (null != obj_conn) {
				((java.sql.Connection) obj_conn).close();
			}
			obj_conn = globalMap.remove("conn_tDBConnection_2");
			if (null != obj_conn) {
				((java.sql.Connection) obj_conn).close();
			}
		} catch (java.lang.Exception e) {
		}
	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
		connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));
		connections.put("conn_tDBConnection_2", globalMap.get("conn_tDBConnection_2"));

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--context_file")) {
			String keyValue = arg.substring(15);
			String filePath = new String(java.util.Base64.getDecoder().decode(keyValue));
			java.nio.file.Path contextFile = java.nio.file.Paths.get(filePath);
			try (java.io.BufferedReader reader = java.nio.file.Files.newBufferedReader(contextFile)) {
				String line;
				while ((line = reader.readLine()) != null) {
					int index = -1;
					if ((index = line.indexOf('=')) > -1) {
						if (line.startsWith("--context_param")) {
							if ("id_Password".equals(context_param.getContextType(line.substring(16, index)))) {
								context_param.put(line.substring(16, index),
										routines.system.PasswordEncryptUtil.decryptPassword(line.substring(index + 1)));
							} else {
								context_param.put(line.substring(16, index), line.substring(index + 1));
							}
						} else {// --context_type
							context_param.setContextType(line.substring(15, index), line.substring(index + 1));
						}
					}
				}
			} catch (java.io.IOException e) {
				System.err.println("Could not load the context file: " + filePath);
				e.printStackTrace();
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 172724 characters generated by Talend Cloud Data Management Platform on the 3
 * December 2024 at 10:14:44 pm IST
 ************************************************************************************************/