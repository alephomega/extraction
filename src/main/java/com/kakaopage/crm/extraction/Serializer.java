package com.kakaopage.crm.extraction;


import com.kakaopage.crm.extraction.ra.Relation;
import com.kakaopage.crm.extraction.ra.RelationalAlgebraOperator;

import java.util.*;

public class Serializer {

    public static Process serialize(Extraction extraction) {
        ExpressionTree tree = new ExpressionTree(extraction);
        Process process = extraction.getProcess();

        Sink sink = process.getSink();
        Relation relation = sink.getRelation();

        ExpressionTree.Node root = tree.sub(relation.getName());
        List<Assignment> assignments = serialize(root, process.getAssignments());

        return new Process(process.getName(), process.isRepeated(), assignments, sink);
    }

    private static List<Assignment> serialize(ExpressionTree.Node root, List<Assignment> assignments) {
        List<Assignment> steps = new ArrayList<>();

        if (!root.in.isEmpty()) {
            for (ExpressionTree.Node node : root.in) {
                steps.addAll(serialize(node, assignments));
            }
        }

        Assignment assignment = find(assignments, root.var);
        if (assignment != null) {
            steps.add(assignment);
        }

        return steps;
    }

    private static Assignment find(List<Assignment> assignments, String var) {
        for (Assignment assignment : assignments) {
            if (assignment.getVariable().equals(var)) {
                return assignment;
            }
        }

        return null;
    }

    private static class ExpressionTree {
        private Map<String, Node> map = new HashMap<>();

        ExpressionTree(Extraction extraction) {
            Process process = extraction.getProcess();
            List<Assignment> assignments = process.getAssignments();
            for (Assignment assignment : assignments) {
                add(assignment);
            }
        }

        private void add(Assignment assignment) {
            RelationalAlgebraOperator operation = assignment.getOperation();
            List<Relation> input = (List<Relation>) operation.getOperands();
            for (Relation relation : input) {
                link(relation.getName(), assignment.getVariable());
            }
        }


        void link(String from, String to) {
            Node n1 = map.get(from);
            if (n1 == null) {
                n1 = new Node(from);
                map.put(from, n1);
            }

            Node n2 = map.get(to);
            if (n2 == null) {
                n2 = new Node(to);
                map.put(to, n2);
            }

            Node.link(n1, n2);
        }

        Node sub(String var) {
            return map.get(var);
        }

        private static class Node {
            String var;
            List<Node> in = new LinkedList<>();
            List<Node> out = new LinkedList<>();

            Node(String var) {
                assert var != null: "var can not be null";
                this.var = var;
            }

            @Override
            public int hashCode() {
                return var.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Node) {
                    return var.equals(((Node) obj).var);
                }

                return false;
            }

            static void link(Node from, Node to) {
                from.out.add(to);
                to.in.add(from);
            }
        }

    }
}