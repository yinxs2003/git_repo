package pb.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 部门实体
 * @author chen
 *
 */
public class Dept {

	// 实体属性名和表列名保持一致（mybatis自动转换）
	@NotNull(message="请输入部门编号")
	private Integer deptno;
	@NotNull(message="请输入部门名称")
	@Size(min=2,max=10,message="部门名称必须在{min}到{max}字符之间")
	private String dname;
	private String loc;
	
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
