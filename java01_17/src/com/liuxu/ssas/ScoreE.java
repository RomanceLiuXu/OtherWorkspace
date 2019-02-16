package com.liuxu.ssas;

import java.util.ArrayList;
import java.util.List;

import com.lanou.IScore;
import com.lanou.Student;

/**
 *
 * @author LiuXu
 * @time2018年6月10日下午3:29:26
 **/
public class ScoreE implements com.liuxu.ssas.IScore {

	static List<AScoreE> scoreList = new ArrayList<>();

	@Override
	public boolean addScore(AScoreE ae) {
		if (ae != null) {
			return scoreList.add(ae);
		}
		return false;
	}

	@Override
	public boolean removeScore(AScoreE ae) {

		return false;
	}

	@Override
	public boolean removeScore(int id, String subjectName) {
		for (AScoreE aScoreE : scoreList) {
			if (aScoreE.getId() == id) {
				if (aScoreE.getSubjectName().equals(subjectName)) {

					return scoreList.remove(aScoreE);
				}
			}
		}
		return false;
	}

	@Override
	public List<AScoreE> selectSub(int id) {
		List<AScoreE> as = new ArrayList<>();
		for (AScoreE aScoreE : scoreList) {
			if (aScoreE.getId() == id) {
				as.add(aScoreE);
			}
		}

		return as;
	}

}
