package MyProject.eluosi.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class imgButton extends JButton {

    public imgButton(ImageIcon imgic) {
        setContentAreaFilled(false);

        setIcon(imgic);
        setBorder(null);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }

    public abstract void onClick();
}
