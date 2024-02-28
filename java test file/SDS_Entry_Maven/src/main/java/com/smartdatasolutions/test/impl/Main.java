package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.util.List;
import java.util.Map;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		return new MemberImporterImpl();
	}

	@Override
    protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
        Set<Member> uniqueMembers = new HashSet<>(membersFromFile);
        return new ArrayList<>(uniqueMembers);
    }

    @Override
    protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
        Map<String, List<Member>> membersByState = new HashMap<>();

        for (Member member : validMembers) {
            String state = member.getState();
            membersByState.putIfAbsent(state, new ArrayList<>());
            membersByState.get(state).add(member);
        }
        return membersByState;
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            String inputFilePath = "Member.txt";
            String outputDirectoryPath = "output";
            String outputFileName = "outputFile.csv";
            main.convert(new File(inputFilePath), outputDirectoryPath, outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
