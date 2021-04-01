package g42.CodeQualityAssessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class VoidVisitorComplete {
	private static class MethodNamePrinter extends VoidVisitorAdapter<Void> {
		@Override
		public void visit(MethodDeclaration md, Void arg) {
			super.visit(md, arg);
			System.out.println("Method Name Printed: " + md.getName());
		}
	}

	private static class MethodNameCollector extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(MethodDeclaration md, List<String> collector) {
			super.visit(md, collector);
			collector.add(md.getNameAsString());
		}
	}


	private static final String FILE_PATH = "C:\\Users\\David Gabriel\\git\\ES-2Sem-2021-Grupo-42\\CodeQualityAssessor\\src\\main\\java\\g42\\CodeQualityAssessor\\App.java";

	public static void main(String[] args) throws FileNotFoundException {
		CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));
		//VoidVisitor<Void> methodNameVisitor = new MethodNamePrinter();
		//methodNameVisitor.visit(cu, null);
		List<String> methodNames = new ArrayList<>();
		VoidVisitor<List<String>> methodNameCollector = new MethodNameCollector();
		methodNameCollector.visit(cu, methodNames);
		methodNames.forEach(n -> System.out.println("Method Name Collected: " + n));

	}

}
