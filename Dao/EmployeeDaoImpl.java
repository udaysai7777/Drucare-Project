package com.Employee.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.Employee.Bean.Employee;
import com.Employee.Bean.EmployeeDepartmentsXref;
import com.Employee.Bean.EmployeeDesignationXref;
import com.Employee.Bean.FetchEmployeeDetailsDto;
import com.Employee.Bean.FetchEmployeeNmReq;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Boolean insertEmployeeDetailsUsingMap(Employee insertEmployeeRequest) {

		String queryToInsertEmployeeDetails = "Insert into employees_info_ref(last_nm,first_nm,middle_nm,emp_code,mobile_nm,state_nm,country_nm,city_nm,org_id,is_active)"
				+ "values(:lastNm,:firstNm,:middleNm,:empCode,:mobileNm,:stateNm,:countryNm,:cityNm,:orgId,true)";
		Boolean result = false;
		Map<String, Object> map = new HashMap<>();
		map.put("lastNm", insertEmployeeRequest.getLastNm());
		map.put("firstNm", insertEmployeeRequest.getFirstNm());
		map.put("middleNm", insertEmployeeRequest.getMiddleNm());
		map.put("empCode", insertEmployeeRequest.getEmpCode());
		map.put("mobileNm", insertEmployeeRequest.getMobileNm());
		map.put("stateNm", insertEmployeeRequest.getStateNm());
		map.put("countryNm", insertEmployeeRequest.getCountryNm());
		map.put("cityNm", insertEmployeeRequest.getCityNm());
		map.put("orgId", insertEmployeeRequest.getOrgId());

		try {
			result = namedParameterJdbcTemplate.update(queryToInsertEmployeeDetails, map) > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean insertEmployeeDetailsUsingSqlParameterSource(Employee insertEmployeeRequest) {
		String queryToInsertEmployeeDetails = "Insert into employees_info_ref(last_nm,first_nm,middle_nm,emp_code,mobile_nm,state_nm,country_nm,city_nm,org_id,is_active)"
				+ "values(:lastNm,:firstNm,:middleNm,:empCode,:mobileNm,:stateNm,:countryNm,:cityNm,:orgId,true)";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("lastNm", insertEmployeeRequest.getLastNm());
		parameters.addValue("firstNm", insertEmployeeRequest.getFirstNm());
		parameters.addValue("middleNm", insertEmployeeRequest.getMiddleNm());
		parameters.addValue("empCode", insertEmployeeRequest.getEmpCode());
		parameters.addValue("mobileNm", insertEmployeeRequest.getMobileNm());
		parameters.addValue("stateNm", insertEmployeeRequest.getStateNm());
		parameters.addValue("countryNm", insertEmployeeRequest.getCountryNm());
		parameters.addValue("cityNm", insertEmployeeRequest.getCityNm());
		parameters.addValue("orgId", insertEmployeeRequest.getOrgId());

		Boolean result = false;
		try {
			BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(insertEmployeeRequest);
			result = namedParameterJdbcTemplate.update(queryToInsertEmployeeDetails, source) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean insertEmployeeDetailsUsingBeanPropertySqlParameterSource(Employee insertEmployeeRequest) {
		String queryToInsertEmployeeDetails = "Insert into employees_info_ref(last_nm,first_nm,middle_nm,emp_code,mobile_nm,state_nm,country_nm,city_nm,org_id,is_active)"
				+ "values(:lastNm,:firstNm,:middleNm,:empCode,:mobileNm,:stateNm,:countryNm,:cityNm,:orgId,:isactive)";

		boolean result = false;
		try {
			result = namedParameterJdbcTemplate.update(queryToInsertEmployeeDetails,
					new BeanPropertySqlParameterSource(insertEmployeeRequest)) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//////////////
	@Override
	public Boolean updateEmployeeDetailsUsingMap(Employee updateEmployeeRequest,Long empId) {
		String queryToUpdateEmployeeDetails = "update employees_info_ref set first_nm=:firstNm, middle_nm=:middleNm,last_nm=:lastNm, mobile_nm = :mobileNm where emp_id =:empId";
		Map<String, Object> map = new HashMap<>();
		map.put("empId", updateEmployeeRequest.getEmpId());
		map.put("lastNm", updateEmployeeRequest.getLastNm());
		map.put("firstNm", updateEmployeeRequest.getFirstNm());
		map.put("middleNm", updateEmployeeRequest.getMiddleNm());
		map.put("mobileNm", updateEmployeeRequest.getMobileNm());

		return namedParameterJdbcTemplate.update(queryToUpdateEmployeeDetails, map) > 0;
	}

	public Boolean updateEmployeeDetailsUsingBeanPropertySqlParameterSource1(List<Employee> insertEmployeeRequestList) {
		Boolean result = false;
		for (Employee insertEmployeeRequest : insertEmployeeRequestList) {
			int count = 0;
			KeyHolder holder = new GeneratedKeyHolder();
			String queryForInsertEmployeeData = "insert  into employees_info_ref(last_nm,first_nm,middle_nm,emp_code,mobile_nm,state_nm,country_nm,city_nm,org_id,isactive)+values"
					+ "values(:lastNm,:firstNm,:middleNm,:empCode,:mobileNm,:stateNm,:countryNm,:cityNm,:orgId,true)";

			if (insertEmployeeRequest.getEmpId() == null) {
				result = namedParameterJdbcTemplate.update(queryForInsertEmployeeData,
						new BeanPropertySqlParameterSource(insertEmployeeRequest), holder,
						new String[] { "emp_id" }) > 0;
				insertEmployeeRequest.setEmpId(holder.getKey().longValue());
			} else {

				String queryForUpdateEmployeeData = "Update employees_info_ref set last_nm=:lastNm,first_nm=:firstNm,mobile_nm=:mobileNm where emp_id=:empId";
				result = namedParameterJdbcTemplate.update(queryForUpdateEmployeeData,
						new BeanPropertySqlParameterSource(insertEmployeeRequest)) > 0;
			}
		}
		return result;
	}

	@Override
	public Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest) {
		String queryToUpdateEmployeeDetails = "update employees_info_ref set first_nm=:firstNm, middle_nm=:middleNm,last_nm=:lastNm, mobile_nm = :mobileNm where emp_id =:empId";
		MapSqlParameterSource map = new MapSqlParameterSource();

		map.addValue("empId", updateEmployeeRequest.getEmpId());
		map.addValue("lastNm", updateEmployeeRequest.getLastNm());
		map.addValue("firstNm", updateEmployeeRequest.getFirstNm());
		map.addValue("middleNm", updateEmployeeRequest.getMiddleNm());
		map.addValue("mobileNm", updateEmployeeRequest.getMobileNm());

		return namedParameterJdbcTemplate.update(queryToUpdateEmployeeDetails, map) > 0;
	}

	@Override
	public Boolean insertEmployeeDetails(Employee insertEmployeeRequest) {
		String queryToInsertEmployeeDetails = "Insert into employees_info_ref(last_nm,first_nm,middle_nm,emp_code,mobile_nm,state_nm,country_nm,city_nm,org_id,isactive)"
				+ "values(:lastNm,:firstNm,:middleNm,:empCode,:mobileNm,:stateNm,:countryNm,:cityNm,:orgId,:isactive)";

		KeyHolder holder = new GeneratedKeyHolder();
		int count = 0;
		count = namedParameterJdbcTemplate.update(queryToInsertEmployeeDetails,
				new BeanPropertySqlParameterSource(insertEmployeeRequest), holder, new String[] { "emp_id" });

		long empId = holder.getKey().longValue();

		Boolean result;

		if (count > 0) {

			String queryForInsertEmployeeDepartments = "insert into employee_departments_xref (emp_dept_id,dept_id,org_id,isactive) values(:empDeptId,:deptId,:orgId,true)";

			if (insertEmployeeRequest.getDepartmentList() != null
					&& insertEmployeeRequest.getDepartmentList().size() > 0) {

				for (EmployeeDepartmentsXref employeeDepartment : insertEmployeeRequest.getDepartmentList()) {

					MapSqlParameterSource map = new MapSqlParameterSource();
					map.addValue("empId", empId);
					map.addValue("deptId", employeeDepartment.getDeptId());
					map.addValue("empDeptId", employeeDepartment.getEmpDeptId());
					map.addValue("orgId", employeeDepartment.getOrgId());
					map.addValue("isActive", employeeDepartment.getIsActive());
					result = namedParameterJdbcTemplate.update(queryForInsertEmployeeDepartments, map) > 0;
				}
			}

			String queryForInsertEmployeeDesignations = "insert into employee_designation_xref (emp_design_id,designation_id,emp_id,org_id,isactive) values(:empDesignId,:designationId,:empId,:orgId,true)";
			if (insertEmployeeRequest.getDesignationList() != null
					&& insertEmployeeRequest.getDesignationList().size() > 0) {
				for (EmployeeDesignationXref employeeDesignation : insertEmployeeRequest.getDesignationList()) {
					MapSqlParameterSource map = new MapSqlParameterSource();
					map.addValue("empId", empId);
					map.addValue("designationId", employeeDesignation.getDesignationId());
					map.addValue("empDesignId", employeeDesignation.getEmpDesignId());
					map.addValue("empId", employeeDesignation.getEmpId());
					map.addValue("orgId", employeeDesignation.getOrgId());
					map.addValue("isActive", employeeDesignation.getIsActive());
					result = namedParameterJdbcTemplate.update(queryForInsertEmployeeDesignations, map) > 0;

				}

			}
		}
		return true;
	}
/////

	@Override
	public Boolean insertEmployeeInBatch(Employee insertEmployeeRequest) {
		String queryToInsertEmployeeDetails = "Insert into employee_info_ref(last_nm,first_nm,middle_nm,emp_code,mobile_nm,state_nm,country_nm,city_nm,org_id,isactive)"
				+ "values(:empId,:lastNm,:firstNm,:middleNm,:empCode,:mobileNm,:stateNm,:countryNm,:cityNm,:orgId,:isactive)";
		KeyHolder holder = new GeneratedKeyHolder();
		int count = namedParameterJdbcTemplate.update(queryToInsertEmployeeDetails,
				new BeanPropertySqlParameterSource(insertEmployeeRequest), holder, new String[] { "emp_id" });
		long empId = holder.getKey().longValue();
		Boolean result = false;
		if (count > 0) {
			String queryForInsertEmployeeDepartments = "insert into employee_departments_xref (emp_dept_id,dept_id,org_id,isactive) values(:empDeptId,:deptId,:orgId,true)";
			if (insertEmployeeRequest.getDepartmentList() != null
					&& insertEmployeeRequest.getDepartmentList().size() > 0)
				for (EmployeeDepartmentsXref empDepartmentsxRef : insertEmployeeRequest.getDepartmentList()) {

					MapSqlParameterSource map = new MapSqlParameterSource();
					map.addValue("empId", empId);
					map.addValue("empDeptId", empDepartmentsxRef.getEmpDeptId());
					map.addValue("deptId", empDepartmentsxRef.getDeptId());
					map.addValue("orgId", empDepartmentsxRef.getOrgId());
					map.addValue("IsActive", empDepartmentsxRef.getIsActive());
					result = namedParameterJdbcTemplate.update(queryForInsertEmployeeDepartments, map) > 0;
				}
			String queryForInsertEmployeeDesignation = "insert into employee_designation_xref (emp_design_id,designation_id,emp_id,org_id,isactive) values(:empDesignId,:designationId,:empId,:orgId,true)";
			if (insertEmployeeRequest.getDesignationList() != null
					&& insertEmployeeRequest.getDesignationList().size() > 0)
				for (EmployeeDesignationXref empDesignationXref : insertEmployeeRequest.getDesignationList()) {
					MapSqlParameterSource map = new MapSqlParameterSource();
					map.addValue("empId", empId);
					map.addValue("empDesignationId", empDesignationXref.getEmpDesignId());
					map.addValue("designationId", empDesignationXref.getDesignationId());
					map.addValue("orgId", empDesignationXref.getDesignationId());
					map.addValue("Isactive", empDesignationXref.getDesignationId());
					result = namedParameterJdbcTemplate.update(queryForInsertEmployeeDesignation, map) > 0;
				}
		}
		return result;
	}

	@Override
	public Boolean EmployeesDetailsinBatch(List<Employee> insertEmployeeRequestList) {
		Boolean result = false;
		for (Employee employee : insertEmployeeRequestList) {
			int count = 0;
			KeyHolder holder = new GeneratedKeyHolder();
			String queryToInsertEmployeeDetails = "Insert into employee_info_ref(last_nm,first_nm,middle_nm,emp_code,mobile_no,state_nm,country_nm,city_nm,org_id,isactive)"
					+ "values(:empId,:lastNm,:firstNm,:middleNm,:empCode,:mobileNo,:stateNm,:countryNm,:cityNm,:orgId,:isactive)";
			if (employee.getEmpId() == null) {
				count = namedParameterJdbcTemplate.update(queryToInsertEmployeeDetails,
						new BeanPropertySqlParameterSource(employee), holder, new String[] { "emp_id" });
				Long key = holder.getKey().longValue();
				employee.setEmpId(key);

			} else {
				String queryForUpdateEmployeeData = "Update employee_info_ref set first_nm=:firstNm,last_nm=:lastNm,mobile_no=:mobileNo where emp_id=:empId";
				count = namedParameterJdbcTemplate.update(queryForUpdateEmployeeData,
						new BeanPropertySqlParameterSource(employee));
			}
			if (count > 0) {

				String queryToInsertEmpDeprtments = "insert into employee_departments_xref (emp_dept_id,emp_id,org_id,is_active) values (:deptId,:empId,:orgId,true)";
				List<EmployeeDepartmentsXref> empDeptXrefSave = new ArrayList<>();
				if (employee.getDepartmentList() != null && employee.getDepartmentList().size() > 0)
					for (EmployeeDepartmentsXref employeeDeptXref : employee.getDepartmentList()) {
						employeeDeptXref.setEmpDeptId(holder.getKey().longValue());
						empDeptXrefSave.add(employeeDeptXref);
					}

				SqlParameterSource[] parameters = SqlParameterSourceUtils.createBatch(empDeptXrefSave.toArray());
				namedParameterJdbcTemplate.batchUpdate(queryToInsertEmpDeprtments, parameters);

				String queryToInsertEmpDesignations = "insert into employee_designation_xref (designation_id,emp_id,org_id,is_active) values (:designationId,:empId,:orgId,true)";
				List<EmployeeDesignationXref> empDesignationRefSave = new ArrayList<>();
				if (employee.getDesignationList() != null && employee.getDesignationList().size() > 0) {
					for (EmployeeDesignationXref employeeDesignationBean : employee.getDesignationList()) {
						employeeDesignationBean.setEmpId(holder.getKey().longValue());
						empDesignationRefSave.add(employeeDesignationBean);
						SqlParameterSource[] values = SqlParameterSourceUtils
								.createBatch(empDesignationRefSave.toArray());
						namedParameterJdbcTemplate.batchUpdate(queryToInsertEmpDesignations, values);

					}
				}
			}
		}
		return result;
	}

	@Override
	public String fetchEmployeeNameByEmpIdUsingObject(FetchEmployeeNmReq fetchEmployeeRequest) {

		String queryForFetchEmployeeNmByEmpIdUsingObject = "SELECT concat(first_nm,' ',middle_nm,' ',last_nm)empName from employees_info_ref  where emp_id=:empId and org_id=:orgId and is_active=:isActive";

		return namedParameterJdbcTemplate.queryForObject(queryForFetchEmployeeNmByEmpIdUsingObject,
				new BeanPropertySqlParameterSource(fetchEmployeeRequest), String.class);

	}

	@Override
	public FetchEmployeeDetailsDto fetchEmployeeNameByEmpIdUsingMap(FetchEmployeeNmReq fetchEmployeeRequest) {

		FetchEmployeeDetailsDto fetchEmployeeDetailsDto = new FetchEmployeeDetailsDto();
		String queryForFetchEmployeeNmByEmpIdUsingMap = "SELECT emp_id,last_nm,first_nm,middle_nm,emp_code,mobile_nm,state_nm,country_nm,city_nm,org_id,is_active from employees_info_ref  where emp_id=:empId and org_id=:orgId and is_active=:isActive";
		Map<String, Object> map = namedParameterJdbcTemplate.queryForMap(queryForFetchEmployeeNmByEmpIdUsingMap,
				new BeanPropertySqlParameterSource(fetchEmployeeRequest));

		fetchEmployeeDetailsDto.setEmpId((Long) map.get("emp_id"));
		fetchEmployeeDetailsDto.setLastNm((String) map.get("last_nm"));
		fetchEmployeeDetailsDto.setFirstNm((String) map.get("first_nm"));
		fetchEmployeeDetailsDto.setMiddleNm((String) map.get("middle_nm"));
		fetchEmployeeDetailsDto.setMobileNm((Long) map.get("mobile_nm"));
		fetchEmployeeDetailsDto.setEmpCode((Long) map.get("emp_code"));
		fetchEmployeeDetailsDto.setStateNm((String) map.get("state_nm"));
		fetchEmployeeDetailsDto.setCountryNm((String) map.get("country_nm"));
		fetchEmployeeDetailsDto.setCityNm((String) map.get("city_nm"));
		fetchEmployeeDetailsDto.setOrgId((Long) map.get("org_id"));
		fetchEmployeeDetailsDto.setIsActive((Boolean) map.get("is_active"));

		return fetchEmployeeDetailsDto;

	}

	@Override
	public List<FetchEmployeeDetailsDto> fetchAllEmployeesUsingList(FetchEmployeeDetailsDto fetchEmployeeRequest) {

		List<FetchEmployeeDetailsDto> fetchEmployeeList = new ArrayList<>();

		String queryForFetchEmployeeNmByEmpIdUsingList = "SELECT emp_id,last_nm,first_nm,middle_nm,emp_code,mobile_nm,state_nm,country_nm,city_nm,org_id,is_active from employees_info_ref  where emp_id=:empId and org_id=:orgId and is_active=:isActive";
		StringBuilder query = new StringBuilder(queryForFetchEmployeeNmByEmpIdUsingList);
		if (fetchEmployeeRequest.getEmpId() != null) {
			query.append(
					" AND concat(emp_id,last_nm,first_nm,middle_nm,emp_code,mobile_nm,state_nm,country_nm,city_nm,org_id,is_active) ilike '%' ||:empId||'%' ");

		}

		if (fetchEmployeeRequest.getMobileNm() != null) {
			query.append(" AND mobile_nm=:mobileNm ");
		}
		query.append(" order by mobile_nm desc ");

		List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(query.toString(),
				new BeanPropertySqlParameterSource(fetchEmployeeRequest));
		FetchEmployeeDetailsDto fetchEmployeeDetailsDto = null;
		for (Map<String, Object> row : rows) {
			fetchEmployeeDetailsDto = new FetchEmployeeDetailsDto();
			fetchEmployeeDetailsDto.setEmpId((Long) row.get("emp_id"));
			fetchEmployeeDetailsDto.setFirstNm((String) row.get("first_nm"));
			fetchEmployeeDetailsDto.setMiddleNm((String) row.get("middle_nm"));
			fetchEmployeeDetailsDto.setLastNm((String) row.get("last_nm"));
			fetchEmployeeDetailsDto.setMobileNm((Long) row.get("mobile_nm"));
			fetchEmployeeDetailsDto.setCountryNm((String) row.get("country_nm"));
			fetchEmployeeDetailsDto.setStateNm((String) row.get("state_nm"));
			fetchEmployeeDetailsDto.setOrgId((Long) row.get("org_id"));
			fetchEmployeeDetailsDto.setIsActive((Boolean) row.get("is_active"));

			fetchEmployeeList.add(fetchEmployeeDetailsDto);

		}
		return fetchEmployeeList;
	}

	@Override
	public List<FetchEmployeeDetailsDto> fetchAllEmployeeDetails(FetchEmployeeDetailsDto fetchEmployeeRequest) {

		String fetchAllEmployeeDetails = "SELECT eir.emp_id,eir.last_nm,eir.first_nm,eir.middle_nm,eir.emp_code,eir.mobile_nm,eir.country_nm,eir.state_nm,eir.org_id,eir.is_active,edp.emp_dept_id,edp.dept_id,edp.org_id,edp.is_active,eds.emp_design_id,eds.designation_id,eds.emp_id,eds.org_id,eds.is_active,dr.dept_id,dr.dept_nm,dr.emp_id,dr.org_id,dr.is_active,dsr.designation_id,dsr.emp_id,dsr.designation_nm,dsr.is_active FROM  employees_info_ref  eir INNER JOIN employee_departments_xref  edp ON  eir.emp_id = edp.emp_id  INNER JOIN employee_designation_xref  eds ON eir.emp_id = eds.emp_id INNER JOIN department_ref dr ON edp.dept_id =dr.dept_id INNER JOIN designation_ref dsr ON  eds.emp_id =dsr.emp_id ";

		FetchEmployeeDetailsDto fetchEmployeeDetailsDto = null;

		List<FetchEmployeeDetailsDto> fetchEmployeeDeatilsDtoList = new ArrayList<>();
		List<EmployeeDepartmentsXref> employeeDepartmentList = null;
		List<EmployeeDesignationXref> employeeDesignationList = null;

		List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(fetchAllEmployeeDetails,
				new BeanPropertySqlParameterSource(fetchEmployeeRequest));

		Set<Long> set = new HashSet<>();

		int count = 0;

		for (Map<String, Object> row : rows) {

			count++;

			if (set.add((Long) row.get("emp_id"))) {

				if (fetchEmployeeDetailsDto != null) {

					if (CollectionUtils.isNotEmpty(employeeDepartmentList)) {

						fetchEmployeeDetailsDto.setDepartmentList(employeeDepartmentList);

					}
					if (CollectionUtils.isNotEmpty(employeeDesignationList)) {
						fetchEmployeeDetailsDto.setDesignationList(employeeDesignationList);

					}
					fetchEmployeeDeatilsDtoList.add(fetchEmployeeDetailsDto);

				}

				fetchEmployeeDetailsDto = new FetchEmployeeDetailsDto();
				fetchEmployeeDetailsDto.setEmpId((Long) row.get("emp_id"));
				fetchEmployeeDetailsDto.setLastNm((String) row.get("last_nm"));
				fetchEmployeeDetailsDto.setFirstNm((String) row.get("first_nm"));
				fetchEmployeeDetailsDto.setMiddleNm((String) row.get("middle_nm"));
				fetchEmployeeDetailsDto.setMobileNm((Long) row.get("mobile_nm"));
				fetchEmployeeDetailsDto.setEmpCode((Long) row.get("emp_code"));
				fetchEmployeeDetailsDto.setCountryNm((String) row.get("country_nm"));
				fetchEmployeeDetailsDto.setStateNm((String) row.get("state_nm"));
				employeeDepartmentList = new ArrayList<>();
				employeeDesignationList = new ArrayList<>();
			}
			if (row.get("dept_id") != null) {

				EmployeeDepartmentsXref employeeDeptBean = new EmployeeDepartmentsXref();
				employeeDeptBean.setDeptId((Long) row.get("dept_id"));
				EmployeeDepartmentsXref fechEmpDeptBean = new EmployeeDepartmentsXref();
				fechEmpDeptBean.setEmpDeptId((Long) row.get("emp_dept_id"));
				fechEmpDeptBean.setDeptId((Long) row.get("dept_id"));
				fetchEmployeeDetailsDto.setEmpId((Long) row.get("emp_id"));
				fechEmpDeptBean.setIsActive((Boolean) row.get("isactive"));
				employeeDepartmentList.add(fechEmpDeptBean);
				employeeDepartmentList.add(employeeDeptBean);
			}

			if (row.get("designation_id") != null) {
				EmployeeDesignationXref employeeDesignationBean = new EmployeeDesignationXref();
				employeeDesignationBean.setDesignationId((Long) row.get("designation_id"));

				EmployeeDesignationXref fetchEmpDesignationBean = new EmployeeDesignationXref();
				fetchEmpDesignationBean.setEmpDesignId((Long) row.get("emp_design_id"));
				fetchEmpDesignationBean.setDesignationId((Long) row.get("designation_id"));
				fetchEmpDesignationBean.setEmpId((Long) row.get("emp_id"));
				fetchEmpDesignationBean.setOrgId((Long) row.get("org_id"));
				fetchEmpDesignationBean.setIsActive((Boolean) row.get("is_active"));
				employeeDesignationList.add(fetchEmpDesignationBean);
			}
		}

		if (count == rows.size() && fetchEmployeeDetailsDto != null) {

			fetchEmployeeDetailsDto.setDesignationList(employeeDesignationList);
			fetchEmployeeDetailsDto.setDepartmentList(employeeDepartmentList);
		}

		fetchEmployeeDeatilsDtoList.add(fetchEmployeeDetailsDto);

		if (count == rows.size() && fetchEmployeeDetailsDto != null) {
			if (CollectionUtils.isNotEmpty(employeeDepartmentList)) {

				fetchEmployeeDetailsDto.setDepartmentList(employeeDepartmentList);
			}
			if (CollectionUtils.isNotEmpty(employeeDesignationList)) {
				fetchEmployeeDetailsDto.setDesignationList(employeeDesignationList);
			}
			fetchEmployeeDeatilsDtoList.add(fetchEmployeeDetailsDto);
		}
		return fetchEmployeeDeatilsDtoList;
	}
}
