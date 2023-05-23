package com.avega.company.service;

import java.util.List;

import com.avega.company.pojo.Skill;

public interface SkillSerivce {

	List<Skill> findAllSkills();

	Skill findSkillsByname(String name);

	Skill findSkill(String id);

	boolean createSkill(Skill skill);

	boolean removeSkill(Skill skill);

	Skill editSkill(Skill skill);

}
