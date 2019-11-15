경열		직군별 평균,최대,최소 급여			Memberdetail 관련 +Register
원보 	부서별 평균,최대,최소	 급여		MemberList 관련 +Register
일겸		부서 지역별 직원수				MemberEdit 관련 +Register
은아 	입사년도별 평균,최대,최소	 급여	    MemberDelete 관련 +Register
다정		sal+comm 랭킹				Register
욱재		사수별 부사수 sal+comm 평균		Register

원보 차트 쿼리문 : 
create view dname
as
  select d.deptno as dept, round(avg(e.sal),0) as avgsal , max(e.sal) as maxsal, min(e.sal) as minsal
  from emp e join dept d on e.deptno = d.deptno
  group by d.deptno;

select d.dname, n.dept, n.avgsal, n.maxsal, n.minsal from dept d join dname n on d.deptno = n.dept;