package com.avega.company.serviceImpl;

import java.util.List;

import com.avega.company.daoImpl.SkillDaoImpl;
import com.avega.company.exception.SkillNotFoundException;
import com.avega.company.pojo.Skill;
import com.avega.company.service.SkillSerivce;

public class SkillServiceImpl implements SkillSerivce {

	SkillDaoImpl skillDao = null;

	public SkillServiceImpl() {
		this.skillDao = new SkillDaoImpl();
	}

	@Override
	public List<Skill> findAllSkills() {
		return skillDao.getAllSkills();
	}

	@Override
	public Skill findSkillsByname(String name) {
		return skillDao.getSkillByName(name);
	}

	@Override
	public Skill findSkill(String id) {
		Skill sk = null;
		try {
			sk = skillDao.getSkill(id);
		} catch (SkillNotFoundException e) {
			e.printStackTrace();
		}
		return sk;
	}

	@Override
	public boolean createSkill(Skill skill) {
		return skillDao.addSkill(skill);
	}

	@Override
	public boolean removeSkill(Skill skill) {
		return skillDao.deleteSkill(skill);
	}

	@Override
	public Skill editSkill(Skill skill) {
		return skillDao.updateSkill(skill);
	}

}
