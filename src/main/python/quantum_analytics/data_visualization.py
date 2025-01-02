import pandas as pd
import numpy as np
import plotly.express as px
import plotly.graph_objects as go
from dash import Dash, dcc, html
from dash.dependencies import Input, Output
import random
import time

# Sample Data Generation
def generate_sample_data(num_points=100):
    """Generate random sample data for visualization."""
    data = {
        'timestamp': pd.date_range(start='2023-01-01', periods=num_points, freq='H'),
        'value': np.random.rand(num_points) * 100,
        'category': np.random.choice(['A', 'B', 'C'], num_points)
    }
    return pd.DataFrame(data)

# Initialize Dash app
app = Dash(__name__)

# Layout of the app
app.layout = html.Div([
    html.H1("Advanced Data Visualization Dashboard"),
    dcc.Graph(id='live-update-graph'),
    dcc.Interval(
        id='interval-component',
        interval=1*1000,  # in milliseconds
        n_intervals=0
    ),
    dcc.Dropdown(
        id='category-dropdown',
        options=[
            {'label': 'Category A', 'value': 'A'},
            {'label': 'Category B', 'value': 'B'},
            {'label': 'Category C', 'value': 'C'}
        ],
        value='A',
        multi=False
    ),
    dcc.Graph(id='bar-chart')
])

# Callback for live updates
@app.callback(
    Output('live-update-graph', 'figure'),
    Input('interval-component', 'n_intervals'),
    Input('category-dropdown', 'value')
)
def update_graph(n, selected_category):
    """Update the live graph with new data."""
    df = generate_sample_data()
    filtered_df = df[df['category'] == selected_category]

    # Create a line chart
    fig = go.Figure()
    fig.add_trace(go.Scatter(x=filtered_df['timestamp'], y=filtered_df['value'],
                              mode='lines+markers', name='Value'))
    fig.update_layout(title='Live Data Visualization',
                      xaxis_title='Time',
                      yaxis_title='Value',
                      xaxis_rangeslider_visible=True)
    return fig

# Callback for bar chart
@app.callback(
    Output('bar-chart', 'figure'),
    Input('category-dropdown', 'value')
)
def update_bar_chart(selected_category):
    """Update the bar chart based on selected category."""
    df = generate_sample_data()
    filtered_df = df[df['category'] == selected_category]

    # Create a bar chart
    bar_fig = px.bar(filtered_df, x='timestamp', y='value', title=f'Bar Chart for Category {selected_category}')
    return bar_fig

# Run the app
if __name__ == '__main__':
    app.run_server(debug=True)
