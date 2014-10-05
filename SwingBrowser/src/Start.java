
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.browser.*;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		shell.setLayout(gridLayout);
		
		GridData data = new GridData();
		data.horizontalSpan = 3;

		final Browser browser;
		try {
			browser = new Browser(shell, SWT.NONE);
		} catch (SWTError e) {
			System.out.println("Could not instantiate Browser: " + e.getMessage());
			display.dispose();
			return;
		}
		data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		data.horizontalSpan = 3;
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		browser.setLayoutData(data);

		final Label status = new Label(shell, SWT.NONE);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		status.setLayoutData(data);

		final ProgressBar progressBar = new ProgressBar(shell, SWT.NONE);
		data = new GridData();
		data.horizontalAlignment = GridData.END;
		progressBar.setLayoutData(data);

		browser.addProgressListener(new ProgressListener() {
			@Override
			public void changed(ProgressEvent event) {
					if (event.total == 0) return;                            
					int ratio = event.current * 100 / event.total;
					progressBar.setSelection(ratio);
			}
			@Override
			public void completed(ProgressEvent event) {
				progressBar.setSelection(0);
			}
		});
		browser.addStatusTextListener(new StatusTextListener() {
			@Override
			public void changed(StatusTextEvent event) {
				status.setText(event.text);	
			}
		});
		
		shell.open();
		browser.setUrl("http://d3js.org");
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
		
	}
}
