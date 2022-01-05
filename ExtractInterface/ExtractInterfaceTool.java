import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExtractInterfaceTool {
    public static void main(String[] args) throws IOException {
        String inputFile=null;
        if(args.length>0) inputFile=args[0];
        InputStream is=System.in;
        if (inputFile!=null) is=new FileInputStream(inputFile);
        ANTLRInputStream input=new ANTLRInputStream(is);
        JavaLexer lexer=new JavaLexer(input);
        CommonTokenStream tokenStream=new CommonTokenStream(lexer);
        JavaParser parser=new JavaParser(tokenStream);
        ParseTree tree=parser.compilationUnit();
        ParseTreeWalker walker=new ParseTreeWalker();
        ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
        walker.walk(extractor,tree);
    }

}

