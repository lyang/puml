package lyang.puml.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import net.sourceforge.plantuml.SourceStringReader;

public class Puml {

  private static final Date EXPIRES = new Date(Long.MIN_VALUE);
  private static final String NO_CACHE = "no-cache";

  public static ResponseBuilder renderToResponse(String content, int index) throws IOException {
    return Response.ok(renderToStream(content, index).toByteArray())
        .cacheControl(CacheControl.valueOf(NO_CACHE))
        .expires(EXPIRES);
  }

  private static ByteArrayOutputStream renderToStream(String content, int index) throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    new SourceStringReader(content).outputImage(outputStream, index);
    return outputStream;
  }
}
