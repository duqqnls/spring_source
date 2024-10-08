package pack.entity;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.LazyInitializationException;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor 
@Entity
public class Dept {
	@Id
	private int deptno;
	private String dname;
	private String loc;
	
	// FetchType.LAZY  : Dept 사용 중 Emp는 필요할 때 지연 로딩
	// 세션이 열려있는 동안 세션관련 필요하며 LazyInitializationException 조치가 필요 
	
	// FetchType.EAGER : Dept 사용 중 Emp는 필요할 때 즉시 로딩
	// 메모리 낭비가 있다는 단점이 있다.
	@OneToMany(mappedBy = "dept", fetch=FetchType.EAGER)
	@Builder.Default // Emp 엔티티가 생성될 때 list를 초기화함.
	private List<Emp> list = new ArrayList<Emp>();
	
}
