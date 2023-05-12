package evidencia.pkg3.bd.CustomLists.Alumnos;

import evidencia.pkg3.bd.Conexion;
import evidencia.pkg3.bd.StudentInfoFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Ricardo
 * @param <E>
 */
public class AlumnosList<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private final Color selectedColor;
    private int hoverIndex = -1;

    public AlumnosList() {
        model = new DefaultListModel();
        selectedColor = new Color(204, 204, 204);
        setModel(model);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent me) {
                hoverIndex = -1;
                repaint();
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    Alumno selectedItem = (Alumno) getSelectedValue();
                    
                    StudentInfoFrame frm;
                    
                    if (selectedItem != null) {
                        frm = new StudentInfoFrame(selectedItem.id);
                        frm.pack();
                        frm.setLocationRelativeTo(null);
                        frm.setVisible(true);
                    }
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                checkMouse(me);
            }

            @Override
            public void mouseDragged(MouseEvent me) {
                checkMouse(me);
            }
        });
    }

    private void checkMouse(MouseEvent me) {
        Point p = me.getPoint();
        int index = locationToIndex(p);
        if (index != hoverIndex) {
            hoverIndex = index;
            repaint();
        }
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jList, Object o, int index, boolean selected, boolean focus) {
                AlumnosListItem item = new AlumnosListItem();
                item.setItem(o);
                if (index == hoverIndex) {
                    item.setBackground(selectedColor);
                }
                return item;
            }
        };
    }

    public void addItem(Alumno item) {
        model.addElement(item);
    }
    
    public void removeAllItem() {
        model.removeAllElements();
    }
}
