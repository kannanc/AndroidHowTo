package com.example;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Provides a demo for Frame Layout
 *
 * @author http://kannanchandrasekaran.com
 */
public class FrameLayoutDemo extends BaseDemoActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayoutdemo);
        TextView tv1 = (TextView) findViewById(R.id.f1);
        TextView tv2 = (TextView) findViewById(R.id.f2);
        TextView tv3 = (TextView) findViewById(R.id.f3);
        
        final Queue<TextView> q = new LinkedList<TextView>();
        q.add(tv2);
        q.add(tv3);

        View.OnClickListener listener = new ClickListener(q);
        tv1.setOnClickListener(listener);
        tv2.setOnClickListener(listener);
        tv3.setOnClickListener(listener);
    }

    private static class ClickListener implements View.OnClickListener {
        private final Queue<TextView> m_queue;
        public ClickListener(Queue<TextView> queue) {
            m_queue = queue;
        }

        @Override
        public void onClick(View v) {
            //Make the current view invisible
            TextView currView = (TextView) v;
            v.setVisibility(View.INVISIBLE);
            m_queue.offer(currView);

            //Make the next view visible
            TextView nextView = m_queue.poll();
            nextView.setVisibility(View.VISIBLE);
        }
    }

}
