package com.cc.approval.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cc.employee.domain.Employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="approval")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Approval {
	
	
	@Id
	@Column(name="appr_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long apprNo;
	

	@ManyToOne
	@JoinColumn(name="appr_form_no")
	private ApprForm apprForm;
	
	
	@Column(name="appr_state" , columnDefinition = "varchar(1) default 's'")
	private String apprState;
	
	@Column(name="appr_title")
	private String apprTitle;
	
	@Column(name="appr_content")
	private String apprContent;
	
	@Column(name="reject_content")
	private String rejectContent;
	
	@Column(name="draft_day")
	@CreationTimestamp
	private LocalDate draftDay;
	
	@Column(name="appr_date")
	@UpdateTimestamp
	private LocalDate apprDate;
	
	@Column(name="appr_holi_start")
	private LocalDate apprHoliStart;
	
	@Column(name="appr_holi_end")
	private LocalDate apprHoliEnd;
	
	@Column(name="appr_holi_use_count")
	private Integer apprHoliUseCount;
	
	@Column(name="appr_first_no")
	private int apprFirstNo;
	
	@Column(name="appr_last_no")
	private Integer apprLastNo;
	
	@Column(name="referencer_first_no")
	private Integer referencerFirstNo;
	
	@Column(name="referencer_last_no")
	private Integer referencerLastNo;

	@ManyToOne
	@JoinColumn(name="appr_writer_code")
	private Employee employee;
	
	@Column(name="appr_writer_name")
	private String apprWriterName;
	
	@Column(name="is_deleted", columnDefinition = "varchar(1) default 'N'")
	private String isDeleted;
	
	public void setDeleted() {
	    this.isDeleted = "Y";
	}
}
